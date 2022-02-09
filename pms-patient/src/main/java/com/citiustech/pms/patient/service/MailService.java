package com.citiustech.pms.patient.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender javaMailSenders;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSenders = javaMailSender;
	}

	public boolean sendEmail(String email) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setSubject("Registration Success - CT General Hospital");
		mail.setText("Hurray ! You Registration has been completed. We're glab to welcome you as a part of CT General Hospital.\n"
				+ "Be calm and enjoy in awe as your Health are in the most pamppered hands that prospers Health & Affinity\n");
		try {
			javaMailSenders.send(mail);
			return true;
		}
		catch(MailException exception){
			System.out.println(exception);
			return false;
		}
	}
	
	public boolean sendEmailPasswordReset(String email) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setSubject("Password Reset - CT General Hospital");
		mail.setText("You're Password has been resetted..\n"
				+ "Password : Password123\n"
				+ "After successful Login, it is mandatory to change your default password\n"
				+ "Please Navigate to Change Password");
		try {
			javaMailSenders.send(mail);
			return true;
		}
		catch(MailException exception){
			System.out.println(exception);
			return false;
		}
	}

	public void sendEmailWithAttachment(String email) throws MailException, MessagingException {

		MimeMessage mimeMessage = javaMailSenders.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setTo(email);
		helper.setSubject("Testing Mail API with Attachment");
		helper.setText("Please find the attached document below.");
		ClassPathResource classPathResource = new ClassPathResource("Attachment.pdf");
		helper.addAttachment(classPathResource.getFilename(), classPathResource);
		javaMailSenders.send(mimeMessage);
	}

}
