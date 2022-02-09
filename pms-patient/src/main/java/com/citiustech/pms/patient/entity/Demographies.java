package com.citiustech.pms.patient.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "demographies")
@JsonIgnoreProperties({ "patient", "hibernateLazyInitializer" })
public class Demographies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "title")
	private String title;
	@Column(name = "first_name")
	private String first_name;
	@Column(name = "last_name")
	private String last_name;
	@Column(name = "date_of_birth")
	private String date_of_birth;
	@Column(name = "age")
	private int age;
	@Column(name = "gender")
	private String gender;
	@Column(name = "race")
	private String race;
	@Column(name = "ethinicity")
	private String ethinicity;
	@Column(name = "language")
	private String language;
	@Column(name = "email")
	private String email;
	@Column(name = "patient_portal_access")
	private String patient_portal_access;
	@Column(name = "home_address")
	private String home_address;
	@Column(name = "country_code")
	private long country_code;
	@Column(name = "contact_number")
	private long contact_number;
	private boolean status = true;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isUnlock() {
		return unlock;
	}

	public void setUnlock(boolean unlock) {
		this.unlock = unlock;
	}

	private boolean unlock = true;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "emergency_contact_details_id", referencedColumnName = "id")
	private EmergencyContactDetails emergency_contact_details;

	@OneToOne(mappedBy = "demographies")
	private Patient patient;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getPatient_portal_access() {
		return patient_portal_access;
	}

	public void setPatient_portal_access(String patient_portal_access) {
		this.patient_portal_access = patient_portal_access;
	}

	public String getEthinicity() {
		return ethinicity;
	}

	public void setEthinicity(String ethinicity) {
		this.ethinicity = ethinicity;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHome_address() {
		return home_address;
	}

	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}

	public long getCountryCd() {
		return country_code;
	}

	public void setCountryCd(long countryCd) {
		this.country_code = countryCd;
	}

	public long getContact_number() {
		return contact_number;
	}

	public void setContact_number(long contact_number) {
		this.contact_number = contact_number;
	}

	public EmergencyContactDetails getEmergency_contact_details() {
		return emergency_contact_details;
	}

	public void setEmergency_contact_details(EmergencyContactDetails emergency_contact_details) {
		this.emergency_contact_details = emergency_contact_details;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Demographies [id=" + id + ", title=" + title + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", date_of_birth=" + date_of_birth + ", age=" + age + ", gender=" + gender + ", race=" + race
				+ ", ethinicity=" + ethinicity + ", language=" + language + ", email=" + email + ", home_address="
				+ home_address + ", contact_number=" + contact_number + ", emergency_contact_details="
				+ emergency_contact_details + ", patient=" + patient + "]";
	}

	public static Demographies createDemographies() {
		Demographies d = new Demographies();
		EmergencyContactDetails c = new EmergencyContactDetails();
		d.setEmergency_contact_details(c);
		return d;
	}

}