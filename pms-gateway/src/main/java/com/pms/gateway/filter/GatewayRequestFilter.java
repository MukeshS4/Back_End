package com.pms.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.pms.gateway.config.JwtTokenUtil;
import com.pms.gateway.config.RouterValidator;

import io.jsonwebtoken.ExpiredJwtException;
import reactor.core.publisher.Mono;

@RefreshScope
@Component
public class GatewayRequestFilter implements GlobalFilter, Ordered  {

	private static final Logger log=LoggerFactory.getLogger(GatewayRequestFilter.class);
	
	@Autowired
    private RouterValidator routerValidator;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		final String requestTokenHeader = request.getHeaders().getFirst("Authorization");//.getHeader("Authorization");

		boolean tokenInvalid = false;
		String jwtToken = null;
		// JWT Token is in the form "Bearer token". Remove Bearer word and get
		// only the Token
		if (routerValidator.isSecured.test(request)) {
			if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
				jwtToken = requestTokenHeader.substring(7);
				try {
					tokenInvalid = jwtTokenUtil.isTokenExpired(jwtToken);
				} catch (IllegalArgumentException e) {
					System.out.println("Unable to get JWT Token");
				} catch (ExpiredJwtException e) {
					System.out.println("JWT Token has expired");
				}
			} else {
				log.info("JWT Token does not begin with Bearer String");
			}
		}
		else
			tokenInvalid=false;
		
		if(tokenInvalid)
		{
			return this.onError(exchange, "Authorization header is invalid", HttpStatus.UNAUTHORIZED);
		}
		return chain.filter(exchange);
	}

	private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);
        return response.setComplete();
    }

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return -1;
	}
}

