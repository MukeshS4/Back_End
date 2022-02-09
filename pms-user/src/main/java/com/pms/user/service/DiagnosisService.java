package com.pms.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.user.entity.Diagnosis;
import com.pms.user.repository.DiagnosisRepository;

@Service
public class DiagnosisService {
	
	@Autowired
	public DiagnosisRepository diagnosisRepository;
	
	public List<Diagnosis> getAllDiagnosis(){
		List<Diagnosis> getAllDiagnosis = new ArrayList<>();
		diagnosisRepository.findAll().iterator().forEachRemaining(diag->{
		getAllDiagnosis.add(diag);	
		});
		return getAllDiagnosis;
	}
	
	public boolean createDiagnosis(Diagnosis diagnosis) {
		diagnosisRepository.save(diagnosis);
		return true;
	}

}
