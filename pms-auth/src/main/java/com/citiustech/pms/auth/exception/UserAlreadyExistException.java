package com.citiustech.pms.auth.exception;

import org.springframework.lang.Nullable;

public class UserAlreadyExistException extends Exception{
	
	public UserAlreadyExistException(String exception) {
		super(exception);
	}
	
	public UserAlreadyExistException(@Nullable String exception, @Nullable Throwable cause) {
		super(exception, cause);
	}

}
