package com.pms.user.constant;

public enum AppointmentStatus {

	CREATED(0),
	SCHEDULED(1),
	CANCELLED(2),
	COMPLETED(4);
	
	private int status;
	
	AppointmentStatus(int status){
		this.status=status;
	}

	public int getStatus() {
		return status;
	}
}
