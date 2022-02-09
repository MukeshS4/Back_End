package com.pms.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Medication {
	
	@Id
	@Column(nullable=false)
	private String mId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String genericName;
	
	@Column(nullable=false)
	private String brandName;
	
	@Column(nullable=false)
	private String form;
	
	@Column
	private String strength;

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public Medication(String mId, String name, String genericName, String brandName, String form) {
		super();
		this.mId = mId;
		this.name = name;
		this.genericName = genericName;
		this.brandName = brandName;
		this.form = form;
	}

	public Medication() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Medication [mId=" + mId + ", name=" + name + ", genericName=" + genericName + ", brandName=" + brandName
				+ ", form=" + form + "]";
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

}
