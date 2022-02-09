package com.citiustech.pms.patient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IncorrectEmailAddressException extends Exception{
	
	public IncorrectEmailAddressException(String exception) {
		super(exception);
	}
	
	public IncorrectEmailAddressException(@Nullable String exception , @Nullable Throwable cause)
	{
		super(exception,cause);
	}
}
