
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
    "type",
    "is_fatal"
})
@Generated("jsonschema2pojo")
public class Allergies {
	
	@JsonProperty("allergies")
    private String allergies;
	@JsonProperty("allergyid")
    private String allergyid;
	@JsonProperty("allergyname")
    private String allergyname;
	@JsonProperty("allergydescription")
    private String allergydescription;
	@JsonProperty("allergyc")
    private String allergyc;
    @JsonProperty("type")
    private String type;
    @JsonProperty("is_fatal")
    private boolean isFatal;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("allergyc")
    public String getAllergyc() {
        return allergyc;
    }

    @JsonProperty("allergyc")
    public void setAllergyc(String allergyc) {
        this.allergyc = allergyc;
    }

    public Allergies withAllergyc(String allergyc) {
        this.allergyc = allergyc;
        return this;
    }
    
    @JsonProperty("allergydescription")
    public String getAllergydescription() {
        return allergydescription;
    }

    @JsonProperty("allergydescription")
    public void setAllergydescription(String allergydescription) {
        this.allergydescription = allergydescription;
    }

    public Allergies withAllergydescription(String allergydescription) {
        this.allergydescription = allergydescription;
        return this;
    }
    
    @JsonProperty("allergyname")
    public String getAllergyname() {
        return allergyname;
    }

    @JsonProperty("allergyname")
    public void setAllergyname(String allergyname) {
        this.allergyname = allergyname;
    }

    public Allergies withAllergyname(String allergyname) {
        this.allergyname = allergyname;
        return this;
    }
    @JsonProperty("allergyid")
    public String getAllergyid() {
        return allergyid;
    }

    @JsonProperty("allergyid")
    public void setAllergyid(String allergyid) {
        this.allergyid = allergyid;
    }

    public Allergies withAllergyid(String allergyid) {
        this.allergyid = allergyid;
        return this;
    }
    
    @JsonProperty("allergies")
    public String getAllergies() {
        return allergies;
    }

    @JsonProperty("allergies")
    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public Allergies withAllergies(String allergies) {
        this.allergies = allergies;
        return this;
    }
    
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Allergies withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("is_fatal")
    public boolean getIsFatal() {
        return isFatal;
    }

    @JsonProperty("is_fatal")
    public void setIsFatal(boolean isFatal) {
        this.isFatal = isFatal;
    }

    public Allergies withIsFatal(boolean isFatal) {
        this.isFatal = isFatal;
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

    public Allergies withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        return result;
    }

   

}
