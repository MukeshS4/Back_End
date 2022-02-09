package com.pms.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.user.entity.Medication;
import com.pms.user.repository.MedicationRepository;

@Service
public class MedicationService {
	
	@Autowired
	public MedicationRepository medicationRepository;
	
	public List<Medication> getAllMedication(){
		List<Medication> getAllMedication = new ArrayList<>();
		medicationRepository.findAll().iterator().forEachRemaining(med->{
			getAllMedication.add(med);
		});
		return getAllMedication;
	}
	
	public boolean createMedication(Medication medication) {
		medicationRepository.save(medication);
		return true;
	}

}
