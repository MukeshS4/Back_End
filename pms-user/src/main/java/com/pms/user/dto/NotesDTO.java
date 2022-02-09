package com.pms.user.dto;

import com.pms.user.entity.UserData;

public class NotesDTO {
	
	private UserData receiver;
	private String sender;
	private String message;
	private boolean priority;
	private String status;
	private long parentNotesId;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isPriority() {
		return priority;
	}
	public void setPriority(boolean priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getParentNotesId() {
		return parentNotesId;
	}
	public void setParentNotesId(long parentNotesId) {
		this.parentNotesId = parentNotesId;
	}
	public UserData getReceiver() {
		return receiver;
	}
	public void setReceiver(UserData receiver) {
		this.receiver = receiver;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	

}
