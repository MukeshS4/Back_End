
package com.citiustech.pms.auth.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
	"title",
    "first_name",
    "last_name",
    "date_of_birth",
    "age",
    "gender",
    "race",
    "ethinicity",
    "language",
    "email",
    "home_address",
    "country_code",
    "contact_number",
    "emergency_contact_details"
})
@Generated("jsonschema2pojo")
public class Demographies {
	
	@JsonProperty("id")
	private int id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("title")
    private String title;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("date_of_birth")
    private String dateOfBirth;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("race")
    private String race;
    @JsonProperty("ethinicity")
    private String ethinicity;
    @JsonProperty("language")
    private String language = null;
    @JsonProperty("email")
    private String email;
    @JsonProperty("home_address")
    private String homeAddress;
    @JsonProperty("country_code")
    private Long countryCd;
    @JsonProperty("contact_number")
    private Long contactNumber;
    @JsonProperty("emergency_contact_details")
    private EmergencyContactDetails emergencyContactDetails;
    @JsonProperty("status")
    private boolean status;
    @JsonProperty("unlock")
    private boolean unlock;
    
    @JsonProperty("status")
    public boolean isStatus() {
		return status;
	}
    @JsonProperty("status")
	public void setStatus(boolean status) {
		this.status = status;
	}
    @JsonProperty("unlock")
	public boolean isUnlock() {
		return unlock;
	}
    @JsonProperty("unlock")
	public void setUnlock(boolean unlock) {
		this.unlock = unlock;
	}

	@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Demographies withTitle(String title) {
        this.title = title;
        return this;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Demographies withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Demographies withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @JsonProperty("date_of_birth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @JsonProperty("date_of_birth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Demographies withDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    public Demographies withAge(Integer age) {
        this.age = age;
        return this;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    public Demographies withGender(String gender) {
        this.gender = gender;
        return this;
    }

    @JsonProperty("race")
    public String getRace() {
        return race;
    }

    @JsonProperty("race")
    public void setRace(String race) {
        this.race = race;
    }

    public Demographies withRace(String race) {
        this.race = race;
        return this;
    }

    @JsonProperty("ethinicity")
    public String getEthinicity() {
        return ethinicity;
    }

    @JsonProperty("ethinicity")
    public void setEthinicity(String ethinicity) {
        this.ethinicity = ethinicity;
    }

    public Demographies withEthinicity(String ethinicity) {
        this.ethinicity = ethinicity;
        return this;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    public Demographies withLanguage(String language) {
        this.language = language;
        return this;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    public Demographies withEmail(String email) {
        this.email = email;
        return this;
    }

    @JsonProperty("home_address")
    public String getHomeAddress() {
        return homeAddress;
    }

    @JsonProperty("home_address")
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Demographies withHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
        return this;
    }
    @JsonProperty("country_code")
    public Long getCountryCd() {
        return countryCd;
    }

    @JsonProperty("country_code")
    public void setCountryCd(Long countryCd) {
        this.countryCd = countryCd;
    }

    public Demographies withCountryCd(Long countryCd) {
        this.countryCd = countryCd;
        return this;
    }
    
    @JsonProperty("contact_number")
    public Long getContactNumber() {
        return contactNumber;
    }

    @JsonProperty("contact_number")
    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Demographies withContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
        return this;
    }

    @JsonProperty("emergency_contact_details")
    public EmergencyContactDetails getEmergencyContactDetails() {
        return emergencyContactDetails;
    }

    @JsonProperty("emergency_contact_details")
    public void setEmergencyContactDetails(EmergencyContactDetails emergencyContactDetails) {
        this.emergencyContactDetails = emergencyContactDetails;
    }

    public Demographies withEmergencyContactDetails(EmergencyContactDetails emergencyContactDetails) {
        this.emergencyContactDetails = emergencyContactDetails;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Demographies withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.lastName == null)? 0 :this.lastName.hashCode()));
        result = ((result* 31)+((this.gender == null)? 0 :this.gender.hashCode()));
        result = ((result* 31)+((this.race == null)? 0 :this.race.hashCode()));
        result = ((result* 31)+((this.dateOfBirth == null)? 0 :this.dateOfBirth.hashCode()));
        result = ((result* 31)+((this.language == null)? 0 :this.language.hashCode()));
        result = ((result* 31)+((this.emergencyContactDetails == null)? 0 :this.emergencyContactDetails.hashCode()));
        result = ((result* 31)+((this.firstName == null)? 0 :this.firstName.hashCode()));
        result = ((result* 31)+((this.contactNumber == null)? 0 :this.contactNumber.hashCode()));
        result = ((result* 31)+((this.ethinicity == null)? 0 :this.ethinicity.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.age == null)? 0 :this.age.hashCode()));
        result = ((result* 31)+((this.email == null)? 0 :this.email.hashCode()));
        result = ((result* 31)+((this.homeAddress == null)? 0 :this.homeAddress.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Demographies) == false) {
            return false;
        }
        Demographies rhs = ((Demographies) other);
        return ((((((((((((((this.lastName == rhs.lastName)||((this.lastName!= null)&&this.lastName.equals(rhs.lastName)))&&((this.gender == rhs.gender)||((this.gender!= null)&&this.gender.equals(rhs.gender))))&&((this.race == rhs.race)||((this.race!= null)&&this.race.equals(rhs.race))))&&((this.dateOfBirth == rhs.dateOfBirth)||((this.dateOfBirth!= null)&&this.dateOfBirth.equals(rhs.dateOfBirth))))&&((this.language == rhs.language)||((this.language!= null)&&this.language.equals(rhs.language))))&&((this.emergencyContactDetails == rhs.emergencyContactDetails)||((this.emergencyContactDetails!= null)&&this.emergencyContactDetails.equals(rhs.emergencyContactDetails))))&&((this.firstName == rhs.firstName)||((this.firstName!= null)&&this.firstName.equals(rhs.firstName))))&&((this.contactNumber == rhs.contactNumber)||((this.contactNumber!= null)&&this.contactNumber.equals(rhs.contactNumber))))&&((this.ethinicity == rhs.ethinicity)||((this.ethinicity!= null)&&this.ethinicity.equals(rhs.ethinicity))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.age == rhs.age)||((this.age!= null)&&this.age.equals(rhs.age))))&&((this.email == rhs.email)||((this.email!= null)&&this.email.equals(rhs.email))))&&((this.homeAddress == rhs.homeAddress)||((this.homeAddress!= null)&&this.homeAddress.equals(rhs.homeAddress))));
    }

}
