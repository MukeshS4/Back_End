package com.pms.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.notification.dto.MessageDTO;
import com.pms.notification.service.MessageService;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@PostMapping("/sms")
	public String sendSmsMessage(@RequestBody MessageDTO msgDto) {
		return messageService.sendSms(msgDto);
	}
}
