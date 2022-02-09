package com.citiustech.pms.patient.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.pms.patient.entity.Allergies;
import com.citiustech.pms.patient.entity.Demographies;
import com.citiustech.pms.patient.entity.EmergencyContactDetails;
import com.citiustech.pms.patient.entity.Patient;
import com.citiustech.pms.patient.entity.PatientVisits;
import com.citiustech.pms.patient.entity.VitalSigns;
import com.citiustech.pms.patient.exception.FieldsNotEmptyException;
import com.citiustech.pms.patient.model.Appointment;
import com.citiustech.pms.patient.model.PatientForm;
import com.citiustech.pms.patient.model.PatientVisit;
import com.citiustech.pms.patient.repository.DemographyRepository;
import com.citiustech.pms.patient.repository.PatientDiagnosisRepository;
import com.citiustech.pms.patient.repository.PatientMedicationRepository;
import com.citiustech.pms.patient.repository.PatientProcedureRepository;
import com.citiustech.pms.patient.repository.PatientRepository;
import com.citiustech.pms.patient.repository.PatientVisitRepository;
import com.citiustech.pms.patient.repository.VitalSignsReposiitory;

@Service
public class PatientDataService {
	
	@Autowired
	PmsUserProxy userProxy;

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	DemographyRepository demoRepo;

	@Autowired
	PatientVisitRepository patientVisitRepository;

	@Autowired
	VitalSignsReposiitory vsRepo;
	@Autowired
	PatientDiagnosisRepository diagnosisRepo;
	@Autowired
	PatientMedicationRepository mdRepo;
	@Autowired
	PatientVisitRepository ptVisitRepo;
	@Autowired
	PatientProcedureRepository psRepo;

	public Patient savePatient(PatientForm patient) throws Exception {
		Patient pt = null;
		if (patient != null && patient.getDemographies() != null && patient.getDemographies().getPatientId() != null) {
			Optional<Patient> ptOpt = patientRepository.findById(patient.getDemographies().getPatientId());
			if (ptOpt != null && ptOpt.isPresent())
				pt = ptOpt.get();
		}
		if (pt == null) {
			pt = new Patient();
			Demographies dmo = new Demographies();
			EmergencyContactDetails ec = new EmergencyContactDetails();
			dmo.setEmergency_contact_details(ec);
			pt.setDemographies(dmo);
			Allergies alrg = new Allergies();
			pt.setAllergies(alrg);
		}
		if (patient != null) {
			// Patient pt = new Patient();
			Demographies dmo = pt.getDemographies();
			dmo.setAge(patient.getDemographies().getAge());
			dmo.setTitle(patient.getDemographies().getTitle());
			dmo.setContact_number(patient.getDemographies().getContactNumber());
			dmo.setDate_of_birth(patient.getDemographies().getDateOfBirth());
			dmo.setEmail(patient.getDemographies().getEmail());
//			if(patient.getDemographies().getEmail()!=null) {
//				Patient duplicateEmailCheck=patientRepository.findEmail(patient.getDemographies().getEmail());
//				if(duplicateEmailCheck.equals(patient.getDemographies().getEmail())){
//					throw new DuplicateEmailFoundException("Duplicate Email ID is present in the records");
//				}
//				dmo.setEmail(patient.getDemographies().getEmail());
//			}
			dmo.setEthinicity(patient.getDemographies().getEthinicity());
			dmo.setFirst_name(patient.getDemographies().getFirstName());
			dmo.setGender(patient.getDemographies().getGender());
			dmo.setHome_address(patient.getDemographies().getHomeAddress());
			dmo.setLanguage(patient.getDemographies().getLanguage().toString());
			dmo.setLast_name(patient.getDemographies().getLastName());
			dmo.setRace(patient.getDemographies().getRace());
			dmo.setCountryCd(patient.getDemographies().getCountryCd());
			dmo.setPatient_portal_access(patient.getDemographies().getPatient_portal_access());
			EmergencyContactDetails ecd = dmo.getEmergency_contact_details();
			ecd.setAddress(patient.getDemographies().getEmergencyContactDetails().getAddress());
			ecd.setContact(patient.getDemographies().getEmergencyContactDetails().getContact());
			// ecd.setE_country_code(patient.getDemographies().getEmergencyContactDetails().getE_country_code());
			ecd.setEmail_address(patient.getDemographies().getEmergencyContactDetails().getEmailAddress());
			ecd.setEcountryCd(patient.getDemographies().getEmergencyContactDetails().getEcountryCd());
			ecd.setE_first_name(patient.getDemographies().getEmergencyContactDetails().getFirstName());
			ecd.setE_last_name(patient.getDemographies().getEmergencyContactDetails().getLastName());
			ecd.setPatient_portal_access(
					patient.getDemographies().getEmergencyContactDetails().getPatientPortalAccess());
			ecd.setRelationship(patient.getDemographies().getEmergencyContactDetails().getRelationship());
			dmo.setEmergency_contact_details(ecd);
			Allergies alr = pt.getAllergies();
			alr.setAllergies(patient.getAllergies().getAllergies());
			alr.setIs_fatal(patient.getAllergies().getIsFatal());
			alr.setAllergyid(patient.getAllergies().getAllergyid());
			alr.setAllergyname(patient.getAllergies().getAllergyname());
			alr.setAllergydescription(patient.getAllergies().getAllergydescription());
			alr.setAllergyc(patient.getAllergies().getAllergyc());
			alr.setType(patient.getAllergies().getType());
			pt.setAllergies(alr);
			pt.setDemographies(dmo);
			patientRepository.save(pt);
			// return pt;

		} else {
			throw new FieldsNotEmptyException("Fields should not be empty");

		}
		return pt;

	}

	public Patient getPatient(Integer id) {
		if (id != null)
			return patientRepository.getById(id);
		return Patient.createPatient();
	}

	public PatientVisits getPatientVisit(Integer id) {
		return patientRepository.getById(id).getVisits();
	}

//	public PatientVisits getPatientVisit(Integer id) {
//		// TODO Auto-generated method stub
//		System.out.println("jvhjfvhf");
//		return patientVisitRepository.getById(id);
//	}
	public PatientVisit savePatientVisit(PatientVisit patientvisit) {
		// TODO Auto-generated method stub
		Optional<Patient> patientOpt = patientRepository.findById(patientvisit.getPatientId());

		Patient patient = patientOpt.get();

		PatientVisits pv = patient.getVisits();
		if (pv == null) {
			pv = new PatientVisits();
			patient.setVisits(pv);
		}
		VitalSigns vs = pv.getVitalSigns();
		if (vs == null) {
			vs = new VitalSigns();
			pv.setVitalSigns(vs);
		}
		vs.setBloodPressure(patientvisit.getVitalSigns().getBloodPressure());
		vs.setBodyTemp(patientvisit.getVitalSigns().getBodyTemp());
		vs.setHeight(patientvisit.getVitalSigns().getHeight());
		vs.setRespirationRate(patientvisit.getVitalSigns().getRespirationRate());
		vs.setWeight(patientvisit.getVitalSigns().getWeight());
		patientRepository.save(patient);
		return patientvisit;
	}

//	public Object getPatientVisits() {
//		// TODO Auto-generated method stub
//		return ptVisitRepo.findAllPatientVisits();
//	}
//	
	public List<Patient> getAllPatient() {
		List<Patient> patientList = new ArrayList<>();
		patientRepository.findAll().iterator().forEachRemaining(patient -> patientList.add(patient));
		return patientList;
	}

	public List<Demographies> getAllBlockedPatients() {
		List<Demographies> blockPatientList = new ArrayList<>();
		return blockPatientList;
	}

	public Patient getPatientByEmailId(String emailId) {
		List<Demographies> demoGraphs = demoRepo.findByEmail(emailId);
		if (demoGraphs != null && !demoGraphs.isEmpty()) {
			return demoGraphs.get(0).getPatient();
		} else {
			System.out.println("No data with specified username");
			return Patient.createPatient();
		}

	}

	public Patient getPatientVisitByEmailId(String emailId) {
		List<Demographies> demoGraphs = demoRepo.findByEmail(emailId);
		if (demoGraphs != null && !demoGraphs.isEmpty()) {
			return demoGraphs.get(0).getPatient();
		} else {
			System.out.println("No data with specified username");
			return Patient.createPatient();
		}
	}

	public List<Integer> getPatientStats() {
		int allPatientCount = demoRepo.getAllPatientsCount();
		int allPatietsLockedCount = demoRepo.getAllPatientsLockedCount();
		int allPatientsInActiveCount = demoRepo.getAllPatientsInActiveCount();
		List<Integer> patientStats = new ArrayList<Integer>();
		patientStats.add(allPatientCount);
		patientStats.add(allPatietsLockedCount);
		patientStats.add(allPatientsInActiveCount);
		return patientStats;
	}

	public List<Appointment> getAppointment(int patientId) {
		return userProxy.getAppointment(patientId);
	}

}
