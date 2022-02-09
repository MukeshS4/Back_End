package com.citiustech.pms.auth.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.citiustech.pms.auth.model.Demographies;
import com.citiustech.pms.auth.model.PatientData;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@FeignClient(name="pms-patient")
public interface PmsPatientProxy {
	
	@GetMapping("/patient/getAllPatients")
	public List<Demographies> getAllPatients();
	
	@GetMapping("/patient/fetchAllBlockedPatientData")
	public List<Demographies>fetchAllBLockedPatient();
	
	@PostMapping("/patient/fetchPatientData")
	public PatientData fetchPatient(@RequestBody String emailId);
	
	@PostMapping("/patient/fetchPatientData")
	public PatientData fetchPatientDemographies(@RequestBody String emailId);
	
	@GetMapping("/patient/fetchAllPatientData")
	public List<Demographies> fetchAllPatient();
	
	@GetMapping("/patient/stats/getPatientsStats")
	public List<Integer> getPatientsStats();
	
	@PostMapping("/patient/overridePatientData")
	public Demographies overrideDemographies(@RequestBody Demographies demographies);
	
//	@PostMapping("/patient/fetchPatientData")
//	public PatientData fetchPatient(@RequestBody String emailId);
	
	

	
}
