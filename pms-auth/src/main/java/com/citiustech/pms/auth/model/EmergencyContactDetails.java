
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
    "first_name",
    "last_name",
    "relationship",
    "email_address",
    "contact",
    "address",
    "patient_portal_access"
})
@Generated("jsonschema2pojo")
public class EmergencyContactDetails {

    @JsonProperty("e_first_name")
    private String e_first_name;
    @JsonProperty("e_last_name")
    private String e_last_name;
    @JsonProperty("relationship")
    private String relationship;
    @JsonProperty("email_address")
    private String emailAddress;
    @JsonProperty("contact")
    private Long contact;
    @JsonProperty("address")
    private String address;
    @JsonProperty("patient_portal_access")
    private String patientPortalAccess;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("e_first_name")
    public String getFirstName() {
        return e_first_name;
    }

    @JsonProperty("e_first_name")
    public void setFirstName(String e_first_name) {
        this.e_first_name = e_first_name;
    }

    public EmergencyContactDetails withFirstName(String e_first_name) {
        this.e_first_name = e_first_name;
        return this;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return e_last_name;
    }

    @JsonProperty("last_name")
    public void setLastName(String e_last_name) {
        this.e_last_name = e_last_name;
    }

    public EmergencyContactDetails withLastName(String e_last_name) {
        this.e_last_name = e_last_name;
        return this;
    }

    @JsonProperty("relationship")
    public String getRelationship() {
        return relationship;
    }

    @JsonProperty("relationship")
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public EmergencyContactDetails withRelationship(String relationship) {
        this.relationship = relationship;
        return this;
    }

    @JsonProperty("email_address")
    public String getEmailAddress() {
        return emailAddress;
    }

    @JsonProperty("email_address")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public EmergencyContactDetails withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    @JsonProperty("contact")
    public Long getContact() {
        return contact;
    }

    @JsonProperty("contact")
    public void setContact(Long contact) {
        this.contact = contact;
    }

    public EmergencyContactDetails withContact(Long contact) {
        this.contact = contact;
        return this;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    public EmergencyContactDetails withAddress(String address) {
        this.address = address;
        return this;
    }

    @JsonProperty("patient_portal_access")
    public String getPatientPortalAccess() {
        return patientPortalAccess;
    }

    @JsonProperty("patient_portal_access")
    public void setPatientPortalAccess(String patientPortalAccess) {
        this.patientPortalAccess = patientPortalAccess;
    }

    public EmergencyContactDetails withPatientPortalAccess(String patientPortalAccess) {
        this.patientPortalAccess = patientPortalAccess;
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

    public EmergencyContactDetails withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.e_first_name == null)? 0 :this.e_first_name.hashCode()));
        result = ((result* 31)+((this.e_last_name == null)? 0 :this.e_last_name.hashCode()));
        result = ((result* 31)+((this.emailAddress == null)? 0 :this.emailAddress.hashCode()));
        result = ((result* 31)+((this.address == null)? 0 :this.address.hashCode()));
        result = ((result* 31)+((this.contact == null)? 0 :this.contact.hashCode()));
        result = ((result* 31)+((this.patientPortalAccess == null)? 0 :this.patientPortalAccess.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.relationship == null)? 0 :this.relationship.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EmergencyContactDetails) == false) {
            return false;
        }
        EmergencyContactDetails rhs = ((EmergencyContactDetails) other);
        return (((((((((this.e_first_name == rhs.e_first_name)||((this.e_first_name!= null)&&this.e_first_name.equals(rhs.e_first_name)))&&((this.e_last_name == rhs.e_last_name)||((this.e_last_name!= null)&&this.e_last_name.equals(rhs.e_last_name))))&&((this.emailAddress == rhs.emailAddress)||((this.emailAddress!= null)&&this.emailAddress.equals(rhs.emailAddress))))&&((this.address == rhs.address)||((this.address!= null)&&this.address.equals(rhs.address))))&&((this.contact == rhs.contact)||((this.contact!= null)&&this.contact.equals(rhs.contact))))&&((this.patientPortalAccess == rhs.patientPortalAccess)||((this.patientPortalAccess!= null)&&this.patientPortalAccess.equals(rhs.patientPortalAccess))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.relationship == rhs.relationship)||((this.relationship!= null)&&this.relationship.equals(rhs.relationship))));
    }

}
