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
public class AppointmentEventAudit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="audit_id")
	private long auditId;
	
	@Column(updatable=false)
	private LocalDateTime createdTs;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "Employee_Id")
	private UserData modifiedBy;
	
	@Column(name="Reason", length=150, nullable=false)
	private String reason;
	
	@ManyToOne
	@JoinColumn(name="appointment_id")
	private Appointment appointmentId;

	public long getAuditId() {
		return auditId;
	}

	public void setAuditId(long auditId) {
		this.auditId = auditId;
	}

	public LocalDateTime getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(LocalDateTime createdTs) {
		this.createdTs = createdTs;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Appointment getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Appointment appointmentId) {
		this.appointmentId = appointmentId;
	}

	public AppointmentEventAudit(LocalDateTime createdTs, UserData modifiedBy, String reason,
			Appointment appointmentId) {
		super();
		this.createdTs = createdTs;
		this.modifiedBy = modifiedBy;
		this.reason = reason;
		this.appointmentId = appointmentId;
	}

	@Override
	public String toString() {
		return "AppointmentEventAudit [auditId=" + auditId + ", createdTs=" + createdTs + ", modifiedBy=" + modifiedBy
				+ ", reason=" + reason + ", appointmentId=" + appointmentId + "]";
	}

	public AppointmentEventAudit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserData getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(UserData modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}
