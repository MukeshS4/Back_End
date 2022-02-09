package com.citiustech.pms.patient.model;

import java.time.format.DateTimeFormatter;

import javax.annotation.Generated;


import com.citiustech.pms.patient.entity.PatientAppointment;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "appointmentId", "physicianId", "patientId", "date", "time", "description" })
@Generated("jsonschema2pojo")
public class AppointmentData {
	private String appointmentId;
	private String physicianId;
	private Integer patientId;
	private String date;
	private String time;
	private String description;

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(String physicianId) {
		this.physicianId = physicianId;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static AppointmentData createAppointment(PatientAppointment app) {
		AppointmentData ad = new AppointmentData();
		ad.setAppointmentId(app.getAppointmentId());
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		ad.setDate(df.format(app.getDate()));
		ad.setTime(app.getTime());
		ad.setDescription(app.getDescription());
		ad.setPhysicianId(app.getEmployee().getEmployeeId());
		ad.setPatientId(app.getPatient().getId());
		return ad;
	}

}
