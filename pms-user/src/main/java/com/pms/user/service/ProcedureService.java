package com.pms.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.user.entity.Procedure;
import com.pms.user.repository.ProcedureRepository;

@Service
public class ProcedureService {
	
	@Autowired
	public ProcedureRepository procedureRepository;
	
	public List<Procedure> getAllProcedure(){
		List<Procedure> getAllProcedure = new ArrayList<>();
		procedureRepository.findAll().iterator().forEachRemaining(prod->{
			getAllProcedure.add(prod);
		});
		return getAllProcedure;
	}
	
	public boolean createProcedure(Procedure procedure) {
		procedureRepository.save(procedure);
		return true;
	}

}
