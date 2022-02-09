package com.citiustech.pms.patient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "allergies")
@JsonIgnoreProperties({"patient","hibernateLazyInitializer"})
public class Allergies{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "allergies")
	private String allergies;
	@Column(name = "allergyid")
	private String allergyid;
	@Column(name = "type")
    private String type;
	@Column(name = "allergyname")
    private String allergyname;
	@Column(name = "allergydescription")
    private String allergydescription;
	@Column(name = "allergyc")
    private String allergyc;
	@Column(name = "is_fatal")
    private boolean is_fatal;
    @OneToOne(mappedBy = "allergies")
    private Patient patient;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	public String getAllergyid() {
		return allergyid;
	}
	public void setAllergyid(String allergyid) {
		this.allergyid = allergyid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAllergyname() {
		return allergyname;
	}
	public void setAllergyname(String allergyname) {
		this.allergyname = allergyname;
	}
	public String getAllergydescription() {
		return allergydescription;
	}
	public void setAllergydescription(String allergydescription) {
		this.allergydescription = allergydescription;
	}
	public String getAllergyc() {
		return allergyc;
	}
	public void setAllergyc(String allergyc) {
		this.allergyc = allergyc;
	}
	public boolean isIs_fatal() {
		return is_fatal;
	}
	public void setIs_fatal(boolean is_fatal) {
		this.is_fatal = is_fatal;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		return "Allergies [id=" + id + ", allergies=" + allergies + ", allergyid=" + allergyid + ", type=" + type
				+ ", allergyname=" + allergyname + ", allergydescription=" + allergydescription + ", allergyc="
				+ allergyc + ", is_fatal=" + is_fatal + ", patient=" + patient + "]";
	}
    
}
