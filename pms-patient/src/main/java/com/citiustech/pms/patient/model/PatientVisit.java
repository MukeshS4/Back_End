
package com.citiustech.pms.patient.model;

import java.util.HashMap;
import java.util.List;
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
    "vital_signs",
    "diagnosis",
    "Procedures",
    "medication"
})
@Generated("jsonschema2pojo")
public class PatientVisit {

	@JsonProperty("patientId")
	private Integer patientId;
    @JsonProperty("vital_signs")
    private VitalSigns vitalSigns;
    @JsonProperty("diagnosis")
    private Diagnosis diagnosis;
    @JsonProperty("Procedures")
    private Procedure procedures = null;
    @JsonProperty("medication")
    private Medication medication = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("vital_signs")
    public VitalSigns getVitalSigns() {
        return vitalSigns;
    }

    @JsonProperty("vital_signs")
    public void setVitalSigns(VitalSigns vitalSigns) {
        this.vitalSigns = vitalSigns;
    }

    public PatientVisit withVitalSigns(VitalSigns vitalSigns) {
        this.vitalSigns = vitalSigns;
        return this;
    }

    @JsonProperty("diagnosis")
    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    @JsonProperty("diagnosis")
    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public PatientVisit withDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
        return this;
    }

    @JsonProperty("Procedures")
    public Procedure getProcedures() {
        return procedures;
    }

    @JsonProperty("Procedures")
    public void setProcedures(Procedure procedures) {
        this.procedures = procedures;
    }

    public PatientVisit withProcedures(Procedure procedures) {
        this.procedures = procedures;
        return this;
    }

    @JsonProperty("medication")
    public Medication getMedication() {
        return medication;
    }

    @JsonProperty("medication")
    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public PatientVisit withMedication(Medication medication) {
        this.medication = medication;
        return this;
    }
    
    @JsonProperty("patientId")
    public Integer getPatientId() {
        return patientId;
    }

    @JsonProperty("patientId")
    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public PatientVisit withPatientId(Integer patientId) {
        this.patientId = patientId;
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

    public PatientVisit withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.diagnosis == null)? 0 :this.diagnosis.hashCode()));
        result = ((result* 31)+((this.medication == null)? 0 :this.medication.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.vitalSigns == null)? 0 :this.vitalSigns.hashCode()));
        result = ((result* 31)+((this.procedures == null)? 0 :this.procedures.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PatientVisit) == false) {
            return false;
        }
        PatientVisit rhs = ((PatientVisit) other);
        return ((((((this.diagnosis == rhs.diagnosis)||((this.diagnosis!= null)&&this.diagnosis.equals(rhs.diagnosis)))&&((this.medication == rhs.medication)||((this.medication!= null)&&this.medication.equals(rhs.medication))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.vitalSigns == rhs.vitalSigns)||((this.vitalSigns!= null)&&this.vitalSigns.equals(rhs.vitalSigns))))&&((this.procedures == rhs.procedures)||((this.procedures!= null)&&this.procedures.equals(rhs.procedures))));
    }

}
