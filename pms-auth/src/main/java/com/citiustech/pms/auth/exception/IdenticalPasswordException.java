package com.citiustech.pms.auth.exception;

import org.springframework.lang.Nullable;

public class IdenticalPasswordException extends Exception{
	
	public  IdenticalPasswordException(String exception) {
		super(exception);
	}
	
	public IdenticalPasswordException(@Nullable String exception, @Nullable Throwable cause) {
		super(exception, cause);
	}


}
