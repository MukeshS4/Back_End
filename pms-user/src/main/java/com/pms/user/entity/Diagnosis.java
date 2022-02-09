package com.pms.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Diagnosis {
	
	@Id
	@Column(nullable=false)
	private String dCode;
	
	@Column(nullable=false)
	private String dDescription;
	
	@Column
	private boolean dDepricated;

	public String getdCode() {
		return dCode;
	}

	public void setdCode(String dCode) {
		this.dCode = dCode;
	}

	public String getdDescription() {
		return dDescription;
	}

	public void setdDescription(String dDescription) {
		this.dDescription = dDescription;
	}

	public boolean isdDepricated() {
		return dDepricated;
	}

	public void setdDepricated(boolean dDepricated) {
		this.dDepricated = dDepricated;
	}

	public Diagnosis(String dCode, String dDescription, boolean dDepricated) {
		super();
		this.dCode = dCode;
		this.dDescription = dDescription;
		this.dDepricated = dDepricated;
	}

	public Diagnosis() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Diagnosis [dCode=" + dCode + ", dDescription=" + dDescription + ", dDepricated=" + dDepricated + "]";
	}
	

}
