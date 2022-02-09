package com.pms.user.dto;

import java.io.Serializable;

import com.pms.user.entity.Diagnosis;

public class DiagnosisDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1258253441972614385L;

	private Diagnosis diagnosis;
	
	private boolean isDepricated;

	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}

	public boolean getIsDepricated() {
		return isDepricated;
	}

	public void setIsDepricated(boolean isDepricated) {
		this.isDepricated = isDepricated;
	}

	public DiagnosisDTO(Diagnosis diagnosis, boolean isDepricated) {
		super();
		this.diagnosis = diagnosis;
		this.isDepricated = isDepricated;
	}

	public DiagnosisDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
