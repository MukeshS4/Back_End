package com.citiustech.pms.auth.exception;

import org.springframework.lang.Nullable;

public class IncorrectEmailAddressException extends Exception {

	public IncorrectEmailAddressException(String exception) {
		super(exception);
	}
	
	public IncorrectEmailAddressException(@Nullable String exception, @Nullable Throwable cause) {
		super(exception, cause);
	}
}
