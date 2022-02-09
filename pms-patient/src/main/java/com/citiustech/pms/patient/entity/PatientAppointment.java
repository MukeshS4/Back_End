package com.citiustech.pms.patient.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pms.user.customSquenceGenerator.CustomAppointmentId;
import com.pms.user.entity.UserData;

@Entity
@JsonIgnoreProperties({ "patient", "hibernateLazyInitializer" })
public class PatientAppointment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_id")
	@GenericGenerator(name = "appointment_id", strategy = "com.pms.user.customSquenceGenerator.CustomAppointmentId", parameters = {
			@Parameter(name = CustomAppointmentId.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomAppointmentId.VALUE_PREFIX_PARAMETER, value = "CT_"),
			@Parameter(name = CustomAppointmentId.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String appointmentId;

	@Column(name = "Description", length = 150, nullable = false)
	private String description;

	@Column(name = "Date", nullable = false)
	private LocalDate date;

	@Column(name = "Time", nullable = false, length = 5)
	private String time;

	@Column(name = "Status")
	private int status;

	@Column(length = 10)
	private String createdBy;

	@Column(updatable = false)
	private LocalDateTime createdTs;

	@Column(length = 10)
	private String modifiedBy;
	
	@Column
	private boolean review=false;

	@Column
	private LocalDateTime modifiedTs;

	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@ManyToOne
	@JoinColumn(name = "Employee_Id")
	private UserData employee;

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public UserData getEmployee() {
		return employee;
	}

	public void setEmployee(UserData employee) {
		this.employee = employee;
	}

	public boolean isReview() {
		return review;
	}

	public void setReview(boolean review) {
		this.review = review;
	}
	
	

}
