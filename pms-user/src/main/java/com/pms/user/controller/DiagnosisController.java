package com.pms.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.user.entity.Diagnosis;
import com.pms.user.service.DiagnosisService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RequestMapping("/user")
@RestController
public class DiagnosisController {
	
	@Autowired
	public DiagnosisService diagnosisService;
	
	@GetMapping("/diagnosis")
	public List<Diagnosis> getAllDiagnosis(){
		return diagnosisService.getAllDiagnosis();
	}
	
	@PostMapping("/diagnosis")
	public String createDiagnosis(@RequestBody Diagnosis diagnosis) {
		boolean flag = diagnosisService.createDiagnosis(diagnosis);
		return flag==true?"Already":"Not";
	}

}
