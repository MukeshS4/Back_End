package com.citiustech.pms.auth.model;


public class PatientData {

	private Integer id;
	private String title;
	private String firstName;
	private String lastName;
	private String emailId;
	private String dateOfBirth;
    private long country;
    private long contactNumber;
	private String password;
	private String confirmPassword;
	@Override
	public String toString() {
		return "PatientData [id=" + id + ", title=" + title + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", country=" + country + ", contactNumber="
				+ contactNumber + ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public long getCountry() {
		return country;
	}
	public void setCountry(long country) {
		this.country = country;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public PatientData(Integer id, String title, String firstName, String lastName, String emailId, String dateOfBirth,
			long country, long contactNumber, String password, String confirmPassword) {
		super();
		this.id = id;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.country = country;
		this.contactNumber = contactNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	public PatientData() {
	}
	
	

}
