package com.pms.notification.service;

import com.pms.notification.dto.EmailDTO;

public interface EmailService {
	
	String sendEmail(EmailDTO emailDto);

}
