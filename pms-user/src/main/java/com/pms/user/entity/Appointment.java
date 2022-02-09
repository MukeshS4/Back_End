package com.pms.user.entity;

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

import com.pms.user.customSquenceGenerator.CustomAppointmentId;

@Entity
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_id")
    @GenericGenerator(
        name = "appointment_id", 
        strategy = "com.pms.user.customSquenceGenerator.CustomAppointmentId", 
        parameters = {
            @Parameter(name = CustomAppointmentId.INCREMENT_PARAM, value = "50"),
            @Parameter(name = CustomAppointmentId.VALUE_PREFIX_PARAMETER, value = "CT_"),
            @Parameter(name = CustomAppointmentId.NUMBER_FORMAT_PARAMETER, value = "%05d") })
    private String appointmentId;
	
	@ManyToOne
	@JoinColumn(name = "patient_id", referencedColumnName = "id")
	private PatientData patientData;
	
	@Column(name="Description", length=150, nullable=false)
	private String description;
	
	@Column(name="Date", nullable=false)
	private LocalDate date;
	
	@Column(name="Time", nullable=false, length=5)
	private String time;
	
	@ManyToOne
	@JoinColumn(name = "Employee_Id", referencedColumnName = "Employee_Id")
	private UserData employee;
	
	@Column(name="Status")
	private int status;
	
	@Column(length=10)
	private String createdBy;
	
	@Column(updatable=false)
	private LocalDateTime createdTs;
	
	@Column(length=10)
	private String modifiedBy;
	
	@Column
	private LocalDateTime modifiedTs;
	
	@Column
	private boolean review = false;
	
	public boolean isReview() {
		return review;
	}

	public void setReview(boolean review) {
		this.review = review;
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public PatientData getPatientData() {
		return patientData;
	}

	public void setPatientData(PatientData patientData) {
		this.patientData =patientData;
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

	
	public Appointment(String appointmentId, PatientData patientData, String description, LocalDate date, String time,
			UserData employee, int status, String createdBy, LocalDateTime createdTs, String modifiedBy,
			LocalDateTime modifiedTs, boolean review) {
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
		this.review = review;
	}

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", patientData=" + patientData + ", description="
				+ description + ", date=" + date + ", time=" + time + ", employee=" + employee + ", status=" + status
				+ ", createdBy=" + createdBy + ", createdTs=" + createdTs + ", modifiedBy=" + modifiedBy
				+ ", modifiedTs=" + modifiedTs + ", review=" + review + "]";
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

}
