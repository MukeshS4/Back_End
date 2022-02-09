package com.citiustech.pms.patient.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "patient")
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "demography_id", referencedColumnName = "id")
	private Demographies demographies;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "allergy_id", referencedColumnName = "id")
	private Allergies allergies;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "visit_id", referencedColumnName = "id")
	private PatientVisits visits;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "patient", orphanRemoval = true)
	private Set<PatientAppointment> appointments = new LinkedHashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Demographies getDemographies() {
		return demographies;
	}

	public void setDemographies(Demographies demographies) {
		this.demographies = demographies;
	}

	public Allergies getAllergies() {
		return allergies;
	}

	public void setAllergies(Allergies allergies) {
		this.allergies = allergies;
	}

	public PatientVisits getVisits() {
		return visits;
	}

	public void setVisits(PatientVisits visits) {
		this.visits = visits;
	}
	
	

	public Set<PatientAppointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<PatientAppointment> appointments) {
		this.appointments = appointments;
	}

	public static Patient createPatient() {
		Demographies d = Demographies.createDemographies();
		Patient p = new Patient();
		Allergies a = new Allergies();
		p.setDemographies(d);
		p.setAllergies(a);
		return p;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + "]";
	}

}
