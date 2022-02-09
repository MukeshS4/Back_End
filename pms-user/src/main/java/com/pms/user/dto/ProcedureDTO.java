package com.pms.user.dto;

import java.io.Serializable;

import com.pms.user.entity.Procedure;

public class ProcedureDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1394350994146974731L;

	private Procedure procedure;
	
	private boolean isDepricated;

	public Procedure getProcedure() {
		return procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}

	public boolean getIsDepricated() {
		return isDepricated;
	}

	public void setIsDepricated(boolean isDepricated) {
		this.isDepricated = isDepricated;
	}

	public ProcedureDTO(Procedure procedure, boolean isDepricated) {
		super();
		this.procedure = procedure;
		this.isDepricated = isDepricated;
	}

	public ProcedureDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
