package com.citiustech.pms.patient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DuplicateEmailFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DuplicateEmailFoundException(String message) {
		super(message);
	}
	
	public DuplicateEmailFoundException(String message, Throwable t) {
		super(message, t);
	}
}
