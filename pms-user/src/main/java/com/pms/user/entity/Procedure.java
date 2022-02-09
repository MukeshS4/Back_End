package com.pms.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Procedure {
	
	@Id
	@Column(nullable=false)
	private String pCode;
	
	@Column(nullable=false)
	private String pDescription;
	
	@Column
	private Boolean pDepricated;

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public Boolean getpDepricated() {
		return pDepricated;
	}

	public void setpDepricated(Boolean pDepricated) {
		this.pDepricated = pDepricated;
	}

	public Procedure(String pCode, String pDescription, Boolean pDepricated) {
		super();
		this.pCode = pCode;
		this.pDescription = pDescription;
		this.pDepricated = pDepricated;
	}

	public Procedure() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Procedure [pCode=" + pCode + ", pDescription=" + pDescription + ", pDepricated=" + pDepricated + "]";
	}

}
