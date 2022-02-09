package com.citiustech.pms.patient.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patient_visits")
@JsonIgnoreProperties({"patient", "hibernateLazyInitializer" })
public class PatientVisits {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "vital_sign_id", referencedColumnName = "id")
	private VitalSigns vitalSigns;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "procedure_id", referencedColumnName = "id")
	private PatientProcedure procedure;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "medication_id", referencedColumnName = "id")
	private PatientMedication medication;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "diagnosis_id", referencedColumnName = "id")
	private PatientDiagnosis diagnosis;

	@OneToOne(mappedBy = "visits")
	private Patient patient;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public VitalSigns getVitalSigns() {
		return vitalSigns;
	}

	public void setVitalSigns(VitalSigns vitalSigns) {
		this.vitalSigns = vitalSigns;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public PatientProcedure getProcedure() {
		return procedure;
	}

	public void setProcedure(PatientProcedure procedure) {
		this.procedure = procedure;
	}

	public PatientMedication getMedication() {
		return medication;
	}

	public void setMedication(PatientMedication medication) {
		this.medication = medication;
	}

	public PatientDiagnosis getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(PatientDiagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}

	public static PatientVisits createEmptyVisit() {
		PatientVisits visit = new PatientVisits();
		PatientDiagnosis d = new PatientDiagnosis();
		PatientMedication m = new PatientMedication();
		VitalSigns v = new VitalSigns();
		PatientProcedure p = new PatientProcedure();
		visit.setMedication(m);
		visit.setDiagnosis(d);
		visit.setVitalSigns(v);
		visit.setProcedure(p);
		return visit;
	}

}
