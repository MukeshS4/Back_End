package com.pms.user.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class AppointmentDiagnosisId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="appointment_id")
	private Appointment appointment;
	
	@ManyToOne
	@JoinColumn(name="d_code")
	private Diagnosis diagnosisId;

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Diagnosis getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(Diagnosis diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public AppointmentDiagnosisId(Appointment appointment, Diagnosis diagnosisId) {
		super();
		this.appointment = appointment;
		this.diagnosisId = diagnosisId;
	}

	public AppointmentDiagnosisId() {
		super();
		// TODO Auto-generated constructor stub
	}
}
