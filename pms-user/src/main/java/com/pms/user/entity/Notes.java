package com.pms.user.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Notes {
	
	@Id
	@Column(name="Notes_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long notesId;
	
	@ManyToOne
	@JoinColumn(name = "sender_id", referencedColumnName = "Employee_Id")
	private UserData senderId;
	
	@Column(name = "Message", length = 250, nullable = false)
	private String message;
	
	@Column(name = "Date")
	private LocalDateTime dateTime;
	
	@Column(name = "Priority", columnDefinition = "boolean default true")
	private boolean priority = true;

	@ManyToOne
	@JoinColumn(name = "receiver_id", referencedColumnName = "Employee_Id")
	private UserData receiverId;
	
	@Column(length=10)
	private String status;
	
	@Column
	private long parentNotesId;

	public UserData getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(UserData receiverId) {
		this.receiverId = receiverId;
	}

	public long getNotesId() {
		return notesId;
	}

	public void setNotesId(long notesId) {
		this.notesId = notesId;
	}

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

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public UserData getSenderId() {
		return senderId;
	}

	public void setSenderId(UserData senderId) {
		this.senderId = senderId;
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
	
}
