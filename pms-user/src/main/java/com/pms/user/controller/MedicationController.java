package com.pms.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.user.entity.Medication;
import com.pms.user.service.MedicationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RequestMapping("/user")
@RestController
public class MedicationController {
	
	@Autowired
	public MedicationService medicationService;
	
	@GetMapping("/medication")
	public List<Medication> getAllMedication(){
		return medicationService.getAllMedication();
	}
	
	@PostMapping("/medication")
	public String createMedication(@RequestBody Medication medication) {
		boolean flag = medicationService.createMedication(medication);
		return flag==true?"available":"not";
	}

}
