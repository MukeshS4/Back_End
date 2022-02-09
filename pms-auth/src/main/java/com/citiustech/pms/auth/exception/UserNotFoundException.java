package com.citiustech.pms.auth.exception;

import org.springframework.lang.Nullable;

public class UserNotFoundException extends Exception {
	
	public UserNotFoundException(String exception) {
		super(exception);
	}
	
	public UserNotFoundException(@Nullable String exception, @Nullable Throwable cause) {
		super(exception, cause);
	}

}
