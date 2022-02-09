package com.pms.notification.service;

import com.pms.notification.dto.MessageDTO;

public interface MessageService {

	String sendSms(MessageDTO msgDto);

}
