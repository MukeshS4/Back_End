package com.citiustech.pms.auth.exception;

import org.springframework.lang.Nullable;

public class UserLockedException extends Exception{
	
	public UserLockedException(String exception) {
		super(exception);
	}
	
	public UserLockedException(@Nullable String exception, @Nullable Throwable cause) {
		super(exception, cause);
	}

}
