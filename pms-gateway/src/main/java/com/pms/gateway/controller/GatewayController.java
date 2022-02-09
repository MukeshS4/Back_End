package com.pms.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

	@GetMapping("/fallback")
	public ResponseEntity<String> getFallbackMessage() {
		return new ResponseEntity<>(" The requested service is currently down due to undergoing periodical maintenance. Please reach us out after 24 hours interval, if not reach out to site Admin, Thankyou for your understanding!",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
