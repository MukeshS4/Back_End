package com.citiustech.pms.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.pms.auth.config.JwtTokenUtil;
import com.citiustech.pms.auth.model.JwtRequest;
import com.citiustech.pms.auth.model.Login;
import com.citiustech.pms.auth.model.LoginResponse;
import com.citiustech.pms.auth.model.UserData;
import com.citiustech.pms.auth.service.JwtUserService;
//
//import io.github.resilience4j.bulkhead.annotation.Bulkhead;
//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
//import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
//import io.github.resilience4j.retry.annotation.Retry;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserService userService;

	@RequestMapping(value = "/PMS/pmsLogin/authenticate", method = RequestMethod.POST)
//	@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
//	@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
//	@RateLimiter(name = "default")
//	@Bulkhead(name = "sample-api")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//		} catch (DisabledException e) {
//			throw new Exception("USER_DISABLED", e);
//		} catch (BadCredentialsException e) {
//			throw new Exception("INVALID_CREDENTIALS", e);
//		}
		final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());
		System.out.println("hey +"+ userDetails);
		final String token = jwtTokenUtil.generateToken(userDetails);
		LoginResponse loginResData = userService.getLoginData(authenticationRequest.getUsername());
		loginResData.setAccessToken(token);
		return ResponseEntity.ok(
				new LoginResponse(loginResData.getFirstName(), loginResData.getLastName(), loginResData.getEmailId(),
						loginResData.getName(), loginResData.getRole(), loginResData.getAccessToken()));
	}

	public String hardcodedResponse(Exception ex) {
		return "The server is currently under maintenance. Please try again later";
	}

	@RequestMapping(value = "/PMS/pmsRegister/register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> saveUser(@RequestBody UserData registerData) throws Exception {
		System.out.println("inside register" + registerData);
		return ResponseEntity.ok(userService.save(registerData));
	}

	@RequestMapping(value = "/patientRegister", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> savePatient(@RequestBody Login loginData) throws Exception {
		System.out.println("Hi Auth Proxy called :" + loginData);
		return ResponseEntity.ok(userService.savePatientLogin(loginData));
	}
}
