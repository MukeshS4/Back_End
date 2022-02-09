package com.pms.user.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pms.user.dto.EmailDTO;
import com.pms.user.dto.MessageDTO;

@Service
public class NotificationClient {

	@Autowired
	private RestTemplate restTemplate;
	
	public void sendEmail(EmailDTO emailDto) {
		try
		{
			ResponseEntity<String> response=restTemplate.postForEntity(new URI("http://localhost:8085/email"), emailDto, String.class);
			System.out.println(response.getStatusCodeValue());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendSMS(MessageDTO msgDto) {
		try
		{
			ResponseEntity<String> response=restTemplate.postForEntity(new URI("http://localhost:8085/sms"), msgDto, String.class);
			System.out.println(response.getStatusCodeValue());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
