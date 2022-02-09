package com.pms.user.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class AppointmentDiagnosis implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8669292705626375509L;

	@EmbeddedId
	private AppointmentDiagnosisId appointmentDiagnosisId;
	
	@Column
	private boolean isDepricated;

	public AppointmentDiagnosisId getAppointmentDiagnosiId() {
		return appointmentDiagnosisId;
	}

	public void setAppointmentDiagnosiId(AppointmentDiagnosisId appointmentDiagnosiId) {
		this.appointmentDiagnosisId = appointmentDiagnosiId;
	}

	public boolean isDepricated() {
		return isDepricated;
	}

	public void setDepricated(boolean isDepricated) {
		this.isDepricated = isDepricated;
	}

	public AppointmentDiagnosis(AppointmentDiagnosisId appointmentDiagnosiId, boolean isDepricated) {
		super();
		this.appointmentDiagnosisId = appointmentDiagnosiId;
		this.isDepricated = isDepricated;
	}

	public AppointmentDiagnosis() {
		super();
		// TODO Auto-generated constructor stub
	}
}
