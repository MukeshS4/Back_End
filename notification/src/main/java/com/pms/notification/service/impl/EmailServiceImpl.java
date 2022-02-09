package com.pms.notification.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.pms.notification.dto.EmailDTO;
import com.pms.notification.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public String sendEmail(EmailDTO emailDto) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(emailDto.getSentTo());
		msg.setSubject(emailDto.getSubject());
		msg.setText(emailDto.getBody());
		javaMailSender.send(msg);
		return "Email Sent Successfully";
	}

}
