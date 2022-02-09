
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
    "height",
    "weight",
    "blood_pressure",
    "body_temp",
    "respiration_rate"
})
@Generated("jsonschema2pojo")
public class VitalSigns {

    @JsonProperty("height")
    private String height;
    @JsonProperty("weight")
    private String weight;
    @JsonProperty("blood_pressure")
    private String bloodPressure;
    @JsonProperty("body_temp")
    private String bodyTemp;
    @JsonProperty("respiration_rate")
    private String respirationRate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("height")
    public String getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(String height) {
        this.height = height;
    }

    public VitalSigns withHeight(String height) {
        this.height = height;
        return this;
    }

    @JsonProperty("weight")
    public String getWeight() {
        return weight;
    }

    @JsonProperty("weight")
    public void setWeight(String weight) {
        this.weight = weight;
    }

    public VitalSigns withWeight(String weight) {
        this.weight = weight;
        return this;
    }


    @JsonProperty("blood_pressure")
    public String getBloodPressure() {
		return bloodPressure;
	}

    @JsonProperty("blood_pressure")
	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public VitalSigns withBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
        return this;
    }

    @JsonProperty("body_temp")
    public String getBodyTemp() {
        return bodyTemp;
    }

    @JsonProperty("body_temp")
    public void setBodyTemp(String bodyTemp) {
        this.bodyTemp = bodyTemp;
    }

    public VitalSigns withBodyTemp(String bodyTemp) {
        this.bodyTemp = bodyTemp;
        return this;
    }

    @JsonProperty("respiration_rate")
    public String getRespirationRate() {
        return respirationRate;
    }

    @JsonProperty("respiration_rate")
    public void setRespirationRate(String respirationRate) {
        this.respirationRate = respirationRate;
    }

    public VitalSigns withRespirationRate(String respirationRate) {
        this.respirationRate = respirationRate;
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

    public VitalSigns withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.bloodPressure == null)? 0 :this.bloodPressure.hashCode()));
        result = ((result* 31)+((this.respirationRate == null)? 0 :this.respirationRate.hashCode()));
        result = ((result* 31)+((this.weight == null)? 0 :this.weight.hashCode()));
        result = ((result* 31)+((this.bodyTemp == null)? 0 :this.bodyTemp.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.height == null)? 0 :this.height.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof VitalSigns) == false) {
            return false;
        }
        VitalSigns rhs = ((VitalSigns) other);
        return (((((((this.bloodPressure == rhs.bloodPressure)||((this.bloodPressure!= null)&&this.bloodPressure.equals(rhs.bloodPressure)))&&((this.respirationRate == rhs.respirationRate)||((this.respirationRate!= null)&&this.respirationRate.equals(rhs.respirationRate))))&&((this.weight == rhs.weight)||((this.weight!= null)&&this.weight.equals(rhs.weight))))&&((this.bodyTemp == rhs.bodyTemp)||((this.bodyTemp!= null)&&this.bodyTemp.equals(rhs.bodyTemp))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.height == rhs.height)||((this.height!= null)&&this.height.equals(rhs.height))));
    }

}
