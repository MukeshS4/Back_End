package com.pms.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.user.entity.PatientData;
import com.pms.user.repository.PatientDataRepository;

@Service
public class PatientService {

	@Autowired
	private PatientDataRepository patientDataRepository;
	
	public List<PatientData> getAllPatient(){
		List<PatientData> patientList=new ArrayList<>();
		patientDataRepository.findAll().iterator().forEachRemaining(patient->patientList.add(patient));
		return patientList;
	}
	
	public PatientData getPatientByEmailId(String emailId) {
		return patientDataRepository.findPatientDataByEmailId(emailId);
	}
}
