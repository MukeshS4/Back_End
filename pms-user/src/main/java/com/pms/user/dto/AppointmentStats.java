package com.pms.user.dto;

import java.io.Serializable;
import java.math.BigInteger;

public class AppointmentStats implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int status;
	private long appointmentCount;
	public int getStatus() {
		return status;
	}
	@Override
	public String toString() {
		return "AppointmentStats [status=" + status + ", appointmentCount=" + appointmentCount + "]";
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public AppointmentStats(int status, long appointmentCount) {
		super();
		this.status = status;
		this.appointmentCount = appointmentCount;
	}
	public long getAppointmentCount() {
		return appointmentCount;
	}
	public void setAppointmentCount(long appointmentCount) {
		this.appointmentCount = appointmentCount;
	}
}
