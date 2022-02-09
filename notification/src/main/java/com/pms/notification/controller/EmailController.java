package com.pms.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.notification.dto.EmailDTO;
import com.pms.notification.service.EmailService;

@RestController
@CrossOrigin("*")
public class EmailController {
	
	@Autowired
	private EmailService emailSevice;
	
	@PostMapping("/email")
	public String sendEmail(@RequestBody EmailDTO emailDto) {
		return emailSevice.sendEmail(emailDto);
	}

}
