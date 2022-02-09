package com.pms.user.dto;

public class EmailDTO {
	
	private String sentTo;
	private String subject;
	private String body;
	
	public String getSentTo() {
		return sentTo;
	}
	public void setSentTo(String sentTo) {
		this.sentTo = sentTo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public EmailDTO(String sentTo, String subject, String body) {
		super();
		this.sentTo = sentTo;
		this.subject = subject;
		this.body = body;
	}
	public EmailDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
