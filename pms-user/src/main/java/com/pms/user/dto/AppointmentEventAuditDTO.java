package com.pms.user.dto;

import java.time.LocalDateTime;

public class AppointmentEventAuditDTO {

	private LocalDateTime modifiedAt;
	
	private String modifiedBy;
	
	private String reason;

	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public AppointmentEventAuditDTO(LocalDateTime modifiedAt, String modifiedBy, String reason) {
		super();
		this.modifiedAt = modifiedAt;
		this.modifiedBy = modifiedBy;
		this.reason = reason;
	}

	public AppointmentEventAuditDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
