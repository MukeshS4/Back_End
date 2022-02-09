package com.pms.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.user.dto.ConsultationDTO;
import com.pms.user.service.ConsulationService;

@CrossOrigin("*")
@RequestMapping("/user")
@RestController
public class ConsulationController {

	@Autowired
	private ConsulationService consultationService;
	
	@PostMapping("/consultation/{appointmentId}")
	public String createConsultation(@RequestBody ConsultationDTO consultationDto,@PathVariable String appointmentId) {
		consultationService.createConsultation(consultationDto, appointmentId);
		return "success";
	}
}
