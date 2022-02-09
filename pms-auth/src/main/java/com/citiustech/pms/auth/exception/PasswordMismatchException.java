package com.citiustech.pms.auth.exception;

import org.springframework.lang.Nullable;

public class PasswordMismatchException extends Exception{
	
	public PasswordMismatchException(String exception) {
		super(exception);
	}
	
	public PasswordMismatchException(@Nullable String exception, @Nullable Throwable cause) {
		super(exception, cause);
	}

}
