package com.citiustech.pms.patient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "procedure")
@JsonIgnoreProperties({ "visit", "hibernateLazyInitializer" })
public class PatientProcedure {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "procedures")
	private String procedures;
	@Column(name = "description")
	private String description;

	@OneToOne(mappedBy = "procedure")
	private PatientVisits visit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProcedures() {
		return procedures;
	}

	public void setProcedures(String procedures) {
		this.procedures = procedures;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PatientVisits getVisit() {
		return visit;
	}

	public void setVisit(PatientVisits visit) {
		this.visit = visit;
	}

}
