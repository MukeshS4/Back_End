
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
    "drugID",
    "drugName",
    "drugGenName",
    "drugBrandNames",
    "drugForm",
    "drugStrength"
})
@Generated("jsonschema2pojo")
public class Medication {

    @JsonProperty("drugID")
    private String drugID;
    @JsonProperty("drugName")
    private String drugName;
    @JsonProperty("drugGenName")
    private String drugGenName;
    
    @JsonProperty("drugBrandName")
    private String drugBrandName;
    @JsonProperty("drugForm")
    private String drugForm;
    @JsonProperty("drugStrength")
    private String drugStrength;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    @JsonProperty("drugForm")
    public String getDrugForm() {
        return drugForm;
    }

    @JsonProperty("drugForm")
    public void setDrugForm(String drugForm) {
        this.drugForm = drugForm;
    }

    public Medication withDrugForm(String drugForm) {
        this.drugForm = drugForm;
        return this;
    }

    @JsonProperty("drugStrength")
    public String getDrugStrength() {
        return drugStrength;
    }

    @JsonProperty("drugStrength")
    public void setDrugStrength(String drugStrength) {
        this.drugStrength = drugStrength;
    }

    public Medication withDrugStrength(String drugStrength) {
        this.drugStrength = drugStrength;
        return this;
    }

    @JsonProperty("drugID")
    public String getDrugID() {
        return drugID;
    }

    @JsonProperty("drugID")
    public void setDrugID(String medication) {
        this.drugID = medication;
    }

    public Medication withDrugID(String medication) {
        this.drugID = medication;
        return this;
    }

    @JsonProperty("drugName")
    public String getDrugName() {
        return drugName;
    }

    @JsonProperty("drugName")
    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Medication withDrugName(String drugName) {
        this.drugName = drugName;
        return this;
    }
    @JsonProperty("drugBrandName")
    public String getDrugBrandName() {
        return drugGenName;
    }

    @JsonProperty("drugBrandName")
    public void setDrugBrandName(String drugBrandName) {
        this.drugBrandName = drugBrandName;
    }

    public Medication withDrugBrandName(String drugBrandName) {
        this.drugBrandName = drugBrandName;
        return this;
    }
    @JsonProperty("drugGenName")
    public String getDrugGenName() {
        return drugGenName;
    }

    @JsonProperty("drugGenName")
    public void setDrugGenName(String drugGenName) {
        this.drugGenName = drugGenName;
    }

    public Medication withDrugGenName(String drugGenName) {
        this.drugGenName = drugGenName;
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

    public Medication withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.drugName == null)? 0 :this.drugName.hashCode()));
        result = ((result* 31)+((this.drugGenName == null)? 0 :this.drugGenName.hashCode()));
        result = ((result* 31)+((this.drugID == null)? 0 :this.drugID.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Medication) == false) {
            return false;
        }
        Medication rhs = ((Medication) other);
        return (((((this.drugName == rhs.drugName)||((this.drugName!= null)
        		&&this.drugName.equals(rhs.drugName)))
        		&&((this.drugGenName == rhs.drugGenName)||((this.drugGenName!= null)
        				&&this.drugGenName.equals(rhs.drugGenName))))
        		&&((this.drugID == rhs.drugID)||((this.drugID!= null)&&this.drugID.equals(rhs.drugID))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
