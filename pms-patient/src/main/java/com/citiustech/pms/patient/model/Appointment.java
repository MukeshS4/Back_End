package com.citiustech.pms.patient.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.pms.user.entity.UserData;

public class Appointment {
	
	 	private String appointmentId;
		private PatientsData patientData;
		private String description;
		private LocalDate date;
		private String time;
		private UserData employee;
		private int status;
		private String createdBy;
		private LocalDateTime createdTs;
		private String modifiedBy;
		private LocalDateTime modifiedTs;
		public String getAppointmentId() {
			return appointmentId;
		}
		public void setAppointmentId(String appointmentId) {
			this.appointmentId = appointmentId;
		}
		public PatientsData getPatientData() {
			return patientData;
		}
		public void setPatientData(PatientsData patientData) {
			this.patientData = patientData;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public LocalDate getDate() {
			return date;
		}
		public void setDate(LocalDate date) {
			this.date = date;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public UserData getEmployee() {
			return employee;
		}
		public void setEmployee(UserData employee) {
			this.employee = employee;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		public LocalDateTime getCreatedTs() {
			return createdTs;
		}
		public void setCreatedTs(LocalDateTime createdTs) {
			this.createdTs = createdTs;
		}
		public String getModifiedBy() {
			return modifiedBy;
		}
		public void setModifiedBy(String modifiedBy) {
			this.modifiedBy = modifiedBy;
		}
		public LocalDateTime getModifiedTs() {
			return modifiedTs;
		}
		public void setModifiedTs(LocalDateTime modifiedTs) {
			this.modifiedTs = modifiedTs;
		}
		@Override
		public String toString() {
			return "Appointment [appointmentId=" + appointmentId + ", patientData=" + patientData + ", description="
					+ description + ", date=" + date + ", time=" + time + ", employee=" + employee + ", status="
					+ status + ", createdBy=" + createdBy + ", createdTs=" + createdTs + ", modifiedBy=" + modifiedBy
					+ ", modifiedTs=" + modifiedTs + "]";
		}
		public Appointment(String appointmentId, PatientsData patientData, String description, LocalDate date,
				String time, UserData employee, int status, String createdBy, LocalDateTime createdTs,
				String modifiedBy, LocalDateTime modifiedTs) {
			super();
			this.appointmentId = appointmentId;
			this.patientData = patientData;
			this.description = description;
			this.date = date;
			this.time = time;
			this.employee = employee;
			this.status = status;
			this.createdBy = createdBy;
			this.createdTs = createdTs;
			this.modifiedBy = modifiedBy;
			this.modifiedTs = modifiedTs;
		}
		public Appointment() {
			
		}
		
		
		
		

}
