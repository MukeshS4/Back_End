package com.citiustech.pms.patient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class FieldsNotEmptyException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public FieldsNotEmptyException(String message) {
		super(message);
	}
	
	public FieldsNotEmptyException(String message, Throwable t) {
		super(message, t);
	}
}
