package com.citiustech.pms.auth.model;

import java.io.Serializable;

public class LoginResponse implements Serializable{
	
	private static final long serialVersionUID = 8578023129078683556L;
	private String firstName;
	private String lastName;
	private String emailId;
	private String name;
	private String role;
	private String accessToken;
	private final int expirationDuration = 18000;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public int getExpirationDuration() {
		return expirationDuration;
	}
	@Override
	public String toString() {
		return "LoginResponse [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", name="
				+ name + ", role=" + role + ", accessToken=" + accessToken + ", expirationDuration="
				+ expirationDuration + "]";
	}
	public LoginResponse(String firstName, String lastName, String emailId, String name, String role,
			String accessToken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.name = name;
		this.role = role;
		this.accessToken = accessToken;
	}
	public LoginResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
