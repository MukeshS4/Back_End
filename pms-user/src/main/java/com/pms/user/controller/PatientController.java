package com.pms.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.user.entity.PatientData;
import com.pms.user.service.PatientService;

@RestController
@RequestMapping("/user")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@GetMapping("/patient/details")
	public List<PatientData> getAllPatient(){
		return patientService.getAllPatient();
	}
}
