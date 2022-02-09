package com.citiustech.pms.auth.service;

import javax.mail.MessagingException;

import org.springframework.mail.MailException;

public interface IMailService {

	void sendEmailWithAttachment(String email) throws MailException, MessagingException;

	boolean sendEmail(String email) throws MailException;

}
