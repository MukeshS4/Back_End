package com.citiustech.pms.patient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "vital_signs")
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
public class VitalSigns {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "height")
	private String height;
	@Column(name = "weight")
	private String weight;
	@Column(name = "blood_pressure")
	private String bloodPressure;
	@Column(name = "body_temp")
	private String bodyTemp;
	
	@Column(name = "respiration_rate")
	private String respirationRate;
	
	@OneToOne(mappedBy = "medication")
    private PatientVisits visit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getBodyTemp() {
		return bodyTemp;
	}

	public void setBodyTemp(String bodyTemp) {
		this.bodyTemp = bodyTemp;
	}

	public String getRespirationRate() {
		return respirationRate;
	}

	public void setRespirationRate(String respirationRate) {
		this.respirationRate = respirationRate;
	}

	@Override
	public String toString() {
		return "VitalSigns [id=" + id + ", height=" + height + ", weight=" + weight + ", bloodPressure=" + bloodPressure
				+ ", bodyTemp=" + bodyTemp + ", respirationRate=" + respirationRate + "]";
	}

}
