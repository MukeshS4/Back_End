
package com.citiustech.pms.patient.model;

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
    "demographies",
    "allergies"
})
@Generated("jsonschema2pojo")
public class PatientForm {

    @JsonProperty("demographies")
    private Demographies demographies;
    @JsonProperty("allergies")
    private Allergies allergies;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("demographies")
    public Demographies getDemographies() {
        return demographies;
    }

    @JsonProperty("demographies")
    public void setDemographies(Demographies demographies) {
        this.demographies = demographies;
    }

    public PatientForm withDemographies(Demographies demographies) {
        this.demographies = demographies;
        return this;
    }

    @JsonProperty("allergies")
    public Allergies getAllergies() {
        return allergies;
    }

    @JsonProperty("allergies")
    public void setAllergies(Allergies allergies) {
        this.allergies = allergies;
    }

    public PatientForm withAllergies(Allergies allergies) {
        this.allergies = allergies;
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

    public PatientForm withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.allergies == null)? 0 :this.allergies.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.demographies == null)? 0 :this.demographies.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PatientForm) == false) {
            return false;
        }
        PatientForm rhs = ((PatientForm) other);
        return ((((this.allergies == rhs.allergies)||((this.allergies!= null)&&this.allergies.equals(rhs.allergies)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.demographies == rhs.demographies)||((this.demographies!= null)&&this.demographies.equals(rhs.demographies))));
    }

}
