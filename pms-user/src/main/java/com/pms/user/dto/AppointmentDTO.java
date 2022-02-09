package com.pms.user.dto;

import com.pms.user.entity.PatientData;
import com.pms.user.entity.UserData;

public class AppointmentDTO {

	private String appointmentId;
	private UserData employee;
	private String date;
	private String time;
	private PatientData patientData;
	private String description;
	private String createdByEmailId;
	private int status;
	
	public UserData getEmployee() {
		return employee;
	}
	public void setEmployee(UserData employee) {
		this.employee = employee;
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
	public PatientData getPatientData() {
		return patientData;
	}
	public void setPatientData(PatientData patientData) {
		this.patientData = patientData;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getCreatedByEmailId() {
		return createdByEmailId;
	}
	public void setCreatedByEmailId(String createdByEmailId) {
		this.createdByEmailId = createdByEmailId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
