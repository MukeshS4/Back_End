package com.citiustech.pms.patient.model;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"title",
    "firstName",
    "lastName",
    "emailId",
    "country",
    "contactNumber",
    "dateOfBirth",
    "password",
    "confirmPassword"
    
})
@Generated("jsonschema2pojo")
public class PatientsData {

	 	@JsonProperty("title")
	    private String title;
	    @JsonProperty("firstName")
	    private String firstName;
	    @JsonProperty("lastName")
	    private String lastName;
	    @JsonProperty("emailId")
	    private String emailId;
	    @JsonProperty("country")
	    private Integer country;
	    @JsonProperty("contactNumber")
	    private String contactNumber;
	    @JsonProperty("dateOfBirth")
	    private String dateOfBirth;
	    @JsonProperty("password")
	    private String password;
	    @JsonProperty("confirmPassword")
	    private String confirmPassword;
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
		public Integer getCountry() {
			return country;
		}
		public void setCountry(Integer country) {
			this.country = country;
		}
		public String getContactNumber() {
			return contactNumber;
		}
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
		public String getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
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
	    

}
