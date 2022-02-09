package com.pms.user.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class AppointmentProcedureId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2345345348475065695L;

	@ManyToOne
	@JoinColumn(name="appointment_id")
	private Appointment appointment;
	
	@ManyToOne
	@JoinColumn(name="p_code")
	private Procedure procedureId;

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Procedure getProcedureId() {
		return procedureId;
	}

	public void setProcedureId(Procedure procedureId) {
		this.procedureId = procedureId;
	}

	public AppointmentProcedureId(Appointment appointment, Procedure procedureId) {
		super();
		this.appointment = appointment;
		this.procedureId = procedureId;
	}

	public AppointmentProcedureId() {
		super();
		// TODO Auto-generated constructor stub
	}

	}
