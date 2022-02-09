package com.pms.user.dto;

import java.io.Serializable;
import java.util.List;

import com.pms.user.entity.Appointment;
import com.pms.user.entity.AppointmentDiagnosis;
import com.pms.user.entity.AppointmentMedication;
import com.pms.user.entity.AppointmentProcedure;
import com.pms.user.entity.Medication;

public class PatientAppointmentConsultDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8727521316464894550L;
	
	private Appointment appointment;
	private List<DiagnosisDTO> diagnosis;
	private List<Medication> medication;
	private List<ProcedureDTO> procedure;
	
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	/*
	 * public List<AppointmentDiagnosis> getDiagnosis() { return diagnosis; } public
	 * void setDiagnosis(List<AppointmentDiagnosis> diagnosis) { this.diagnosis =
	 * diagnosis; } public List<AppointmentMedication> getMedication() { return
	 * medication; } public void setMedication(List<AppointmentMedication>
	 * medication) { this.medication = medication; } public
	 * List<AppointmentProcedure> getProcedure() { return procedure; } public void
	 * setProcedure(List<AppointmentProcedure> procedure) { this.procedure =
	 * procedure; }
	 */
	public List<DiagnosisDTO> getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(List<DiagnosisDTO> diagnosis) {
		this.diagnosis = diagnosis;
	}
	public List<Medication> getMedication() {
		return medication;
	}
	public void setMedication(List<Medication> medication) {
		this.medication = medication;
	}
	public List<ProcedureDTO> getProcedure() {
		return procedure;
	}
	public void setProcedure(List<ProcedureDTO> procedure) {
		this.procedure = procedure;
	}
}
