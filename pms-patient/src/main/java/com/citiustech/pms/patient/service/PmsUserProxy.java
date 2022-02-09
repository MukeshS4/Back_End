package com.citiustech.pms.patient.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.citiustech.pms.patient.model.Appointment;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@FeignClient(name="pms-user")
public interface PmsUserProxy {
	
	@RequestMapping(value = "/user/getAppointment", method = RequestMethod.POST)
	public List<Appointment> getAppointment(@RequestBody Integer patientId);

}
