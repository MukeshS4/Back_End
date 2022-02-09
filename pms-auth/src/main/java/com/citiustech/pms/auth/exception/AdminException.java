package com.citiustech.pms.auth.exception;

import org.springframework.lang.Nullable;

public class AdminException extends Exception{
	
	public  AdminException(String exception) {
		super(exception);
	}
	
	public AdminException(@Nullable String exception, @Nullable Throwable cause) {
		super(exception, cause);
	}

}
