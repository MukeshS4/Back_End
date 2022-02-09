package com.pms.user.dto;

public class MessageDTO {
	
	private long sentTo;
	private String message;
	
	public long getSentTo() {
		return sentTo;
	}
	public void setSentTo(long sentTo) {
		this.sentTo = sentTo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MessageDTO(long sentTo, String message) {
		super();
		this.sentTo = sentTo;
		this.message = message;
	}
	public MessageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
