package com.pms.gateway;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.pms.gateway.filter.GatewayRequestFilter;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

@EnableEurekaClient
@SpringBootApplication
public class PmsGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmsGatewayApplication.class, args);
	}
	
	@Bean
	public GlobalFilter customFilter() {
	    return new GatewayRequestFilter();
	}
	
	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
	    return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
	            .timeLimiterConfig(TimeLimiterConfig.custom()
	            .timeoutDuration(Duration.ofSeconds(10)).build())
	            .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
	            .build());
	}
}
