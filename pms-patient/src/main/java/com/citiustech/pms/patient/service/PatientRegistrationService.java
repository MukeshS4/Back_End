package com.citiustech.pms.patient.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.pms.patient.entity.Demographies;
import com.citiustech.pms.patient.entity.PatientRegistrationData;
import com.citiustech.pms.patient.exception.PatientAlreadyExistException;
import com.citiustech.pms.patient.model.Login;
import com.citiustech.pms.patient.model.PatientsData;
import com.citiustech.pms.patient.repository.DemographyRepository;
import com.citiustech.pms.patient.repository.PatientRegistrationRepository;


@Service
public class PatientRegistrationService {
	
	@Autowired
	private PmsAuthProxy pmsAuthProxy;
	
	@Autowired
	private MailService notificationService;

	@Autowired
	private PatientRegistrationRepository patientRegistrationRepo;
	
	@Autowired
	private DemographyRepository demoRepo;
	
	public PatientRegistrationData save(PatientsData registerData)
			throws PatientAlreadyExistException {
		boolean exist = patientExist(registerData.getEmailId());
		if (!exist ) {
			PatientRegistrationData newRegister = new PatientRegistrationData();
			newRegister.setTitle(registerData.getTitle());
			newRegister.setFirstName(registerData.getFirstName());
			newRegister.setLastName(registerData.getLastName());
			newRegister.setEmailId(registerData.getEmailId());
			newRegister.setDateOfBirth(registerData.getDateOfBirth());
			newRegister.setCountry(registerData.getCountry());
			newRegister.setContactNumber(Long.parseLong(registerData.getContactNumber()));
			newRegister.setPassword((registerData.getPassword()));
			newRegister.setConfirmPassword((registerData.getConfirmPassword()));
			loginPatientData(registerData.getEmailId(),registerData.getPassword());
			boolean email = emailNotification(registerData.getEmailId());
			System.out.println(email);
			return patientRegistrationRepo.save(newRegister);
		}else {
			return null;
		}
	}

	public boolean patientExist(String email) throws PatientAlreadyExistException {
		PatientRegistrationData isUser = patientRegistrationRepo.findByEmailId(email);
		if (isUser != null) {
			throw new PatientAlreadyExistException("Patient is already Registered");
		} else {
			return false;
		}
	}
	
	public Object loginPatientData(String username,String password) {
		System.out.println("test 1 - sending to AuthProxy");
		Login loginData = new Login(username,password,"Patient");
		System.out.println(loginData);
		return pmsAuthProxy.savePatient(loginData);
	}
	
	public boolean emailNotification(String email) {
		return notificationService.sendEmail(email);
	}
	
	public PatientRegistrationData fetchPatient(String emailId) {
		return patientRegistrationRepo.findByEmailId(emailId);
	}

	public List<Demographies> fetchAllPatient() {
		return demoRepo.findAllUnBlocked();
	}

	public Demographies adminOverridePatient(Demographies demo) {
		return demoRepo.save(demo);
	}

	public List<Demographies> fetchAllBlockedPatient() {
		return demoRepo.findAllBlocked();
	}
	
}
