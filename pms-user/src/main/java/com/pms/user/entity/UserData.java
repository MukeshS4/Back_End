package com.pms.user.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Check;

@Entity
@Table(
uniqueConstraints = { 
        @UniqueConstraint(columnNames = "Employee_Id") })
	public class UserData {
	

		@Column(nullable=false, length=3)
		private String title;

		@Column(name="First_Name", nullable=false, length=20)
		private String firstName;
		
		@Column(name="Last_Name", nullable=false, length=20)
		private String lastName;
		
		
		@Column(name="Email_Id", nullable=false, length=50)
		@Pattern(regexp="^.+@.+\\..+$")
		private String emailId;
		
		@Column(name="Date_Of_Birth", nullable=false)
		private Date dateOfBirth;
		
		@Check(constraints="'Physician', 'Nurse', 'Admin,")
		@Column(name="Role", nullable=false,length=10)
		private String role;
		
		@Id
		@Column(name="Employee_Id", nullable=false)
		private String employeeId;
		
		@Column(nullable = false)
		private LocalDate dateofJoining;
		
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
		
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
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
		
		@Override
		public String toString() {
			return "UserRegistrationDao [title=" + title + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", dateofJoining=" + dateofJoining
					+ ", role=" + role + ", employeeId=" + employeeId + ", status=" + status + ", unlocked=" + unlocked
					+ "]";
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

}
