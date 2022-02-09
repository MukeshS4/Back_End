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
@Table(name = "emergency_contact_details")
@JsonIgnoreProperties({"demographies"})
public class EmergencyContactDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "e_first_name")
    private String e_first_name;
	@Column(name = "e_last_name")
    private String e_last_name;
	@Column(name = "relationship")
    private String relationship;
	@Column(name = "email_address")
    private String email_address;
	@Column(name = "contact")
    private Long contact;
	
	@Column(name = "ecountryCd")
    private Long ecountryCd;
	@Column(name = "address")
    private String address;
	public Long getEcountryCd() {
		return ecountryCd;
	}
	public void setEcountryCd(Long ecountryCd) {
		this.ecountryCd = ecountryCd;
	}
	@Column(name = "patient_portal_access")
    private String patient_portal_access;
	
	@OneToOne(mappedBy = "emergency_contact_details")
	private Demographies demographies;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getE_first_name() {
		return e_first_name;
	}
	public void setE_first_name(String e_first_name) {
		this.e_first_name = e_first_name;
	}
	
	public String getE_last_name() {
		return e_last_name;
	}
	public void setE_last_name(String e_last_name) {
		this.e_last_name = e_last_name;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String isPatient_portal_access() {
		return patient_portal_access;
	}
	public void setPatient_portal_access(String patient_portal_access) {
		this.patient_portal_access = patient_portal_access;
	}
	public Demographies getDemographies() {
		return demographies;
	}
	public void setDemographies(Demographies demographies) {
		this.demographies = demographies;
	}
	@Override
	public String toString() {
		return "EmergencyContactDetails [id=" + id + ", first_name=" + e_first_name + ", last_name=" + e_last_name
				+ ", relationship=" + relationship + ", email_address=" + email_address + ", contact=" + contact
				+ ", address=" + address + ", patient_portal_access=" + patient_portal_access + "]";
	}
	
}
