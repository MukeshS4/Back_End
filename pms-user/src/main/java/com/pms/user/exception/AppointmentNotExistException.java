package com.pms.user.exception;

public class AppointmentNotExistException extends Exception {

	private String message;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AppointmentNotExistException(String message) {
		super(message);
		this.message=message;
	}

}
