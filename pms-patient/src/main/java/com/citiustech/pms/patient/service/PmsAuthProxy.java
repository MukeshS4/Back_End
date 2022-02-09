package com.citiustech.pms.patient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.citiustech.pms.patient.model.Login;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@FeignClient(name="pms-auth")
public interface PmsAuthProxy {

	@RequestMapping(value = "/patientRegister", method = RequestMethod.POST)
	public Login savePatient(@RequestBody Login loginData);
}
