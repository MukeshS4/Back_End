package com.pms.user.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class AppointmentProcedure {

	@EmbeddedId
	private AppointmentProcedureId appointmentProcedureId;
	
	@Column
	private boolean isDepricated;

	public AppointmentProcedureId getAppointmentProcedureId() {
		return appointmentProcedureId;
	}

	public void setAppointmentProcedureId(AppointmentProcedureId appointmentProcedureId) {
		this.appointmentProcedureId = appointmentProcedureId;
	}

	public boolean isDepricated() {
		return isDepricated;
	}

	public void setDepricated(boolean isDepricated) {
		this.isDepricated = isDepricated;
	}

	public AppointmentProcedure(AppointmentProcedureId appointmentProcedureId, boolean isDepricated) {
		super();
		this.appointmentProcedureId = appointmentProcedureId;
		this.isDepricated = isDepricated;
	}

	public AppointmentProcedure() {
		super();
		// TODO Auto-generated constructor stub
	}
}
