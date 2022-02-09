package com.citiustech.pms.auth.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="User.Data",uniqueConstraints=
@UniqueConstraint(columnNames={"employeeId", "emailId"}))
public class UserDataDao {
	
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String emailId;
	@Column(nullable = false)
	private LocalDate dateOfBirth;
	@Column(nullable = false)
	private LocalDate dateofJoining;
	@Column(nullable = false)
	private String role;
	@Id
	@Column(nullable = false)
	private String employeeId;
	@Column(nullable = false)
	private boolean status;
	@Column(nullable = false)
	private boolean unlocked;
	

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
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate string) {
		this.dateOfBirth = string;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public LocalDate getDateofJoining() {
		return dateofJoining;
	}
	public void setDateofJoining(LocalDate dateofJoining) {
		this.dateofJoining = dateofJoining;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isUnlocked() {
		return unlocked;
	}
	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}
	@Override
	public String toString() {
		return "UserRegistrationDao [title=" + title + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", dateofJoining=" + dateofJoining
				+ ", role=" + role + ", employeeId=" + employeeId + ", status=" + status + ", unlocked=" + unlocked
				+ "]";
	}
	
	
	

}
