package com.pms.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.user.entity.Procedure;
import com.pms.user.service.ProcedureService;

@RequestMapping("/user")
@RestController
public class ProcedureController {
	
	@Autowired
	public ProcedureService procedureService;
	
	@GetMapping("/procedure")
	public List<Procedure> getAllProcedure(){
		return procedureService.getAllProcedure();
	}
	
	@PostMapping("/procedure")
	public String createProcedure(@RequestBody Procedure procedure) {
		boolean flag = procedureService.createProcedure(procedure);
		return flag==true?"Procedure Successfully":"Alredy Exits";
	}

}
