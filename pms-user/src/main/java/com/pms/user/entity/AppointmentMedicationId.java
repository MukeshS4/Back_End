package com.pms.user.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class AppointmentMedicationId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8974424715756208616L;

	@ManyToOne
	@JoinColumn(name="appointment_id")
	private Appointment appointment;
	
	@ManyToOne
	@JoinColumn(name="m_id")
	private Medication medicationId;

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Medication getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(Medication medicationId) {
		this.medicationId = medicationId;
	}

	public AppointmentMedicationId(Appointment appointment, Medication medicationId) {
		super();
		this.appointment = appointment;
		this.medicationId = medicationId;
	}

	public AppointmentMedicationId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
