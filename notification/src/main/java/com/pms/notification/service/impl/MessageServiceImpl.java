package com.pms.notification.service.impl;

import org.springframework.stereotype.Service;

import com.pms.notification.dto.MessageDTO;
import com.pms.notification.service.MessageService;
import com.vonage.client.VonageClient;
import com.vonage.client.sms.MessageStatus;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.messages.TextMessage;

@Service
public class MessageServiceImpl implements MessageService {

	@Override
	public String sendSms(MessageDTO msgDto) {
		try {
			VonageClient client = VonageClient.builder().apiKey("9b459a4e").apiSecret("AjhTNokw6u4Bzatn").build();
			TextMessage message = new TextMessage("Vonage APIs",
			        Long.toString(msgDto.getSentTo()),
			        msgDto.getMessage()
			);

			SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

			if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
			   return "Message sent successfully.";
			} else {
			    return "Message failed with error: " + response.getMessages().get(0).getErrorText();
			}
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}
