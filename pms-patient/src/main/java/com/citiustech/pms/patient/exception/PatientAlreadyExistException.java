package com.citiustech.pms.patient.exception;

import org.springframework.lang.Nullable;

public class PatientAlreadyExistException  extends Exception{

	public PatientAlreadyExistException(String exception) {
		super(exception);
	}
	
	public PatientAlreadyExistException(@Nullable String exception, @Nullable Throwable cause) {
		super(exception, cause);
	}

}
