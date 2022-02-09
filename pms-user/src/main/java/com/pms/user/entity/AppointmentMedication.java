package com.pms.user.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class AppointmentMedication {

	@EmbeddedId
	private AppointmentMedicationId appointmentMedicationId;

	public AppointmentMedicationId getAppointmentMedicationId() {
		return appointmentMedicationId;
	}

	public void setAppointmentMedicationId(AppointmentMedicationId appointmentMedicationId) {
		this.appointmentMedicationId = appointmentMedicationId;
	}

	public AppointmentMedication(AppointmentMedicationId appointmentMedicationId) {
		super();
		this.appointmentMedicationId = appointmentMedicationId;
	}

	public AppointmentMedication() {
		super();
		// TODO Auto-generated constructor stub
	}
}
