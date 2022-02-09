package com.citiustech.pms.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.pms.patient.entity.Demographies;
import com.citiustech.pms.patient.entity.Patient;
import com.citiustech.pms.patient.entity.PatientVisits;
import com.citiustech.pms.patient.exception.RecordNotFoundException;
import com.citiustech.pms.patient.model.Appointment;
import com.citiustech.pms.patient.model.AppointmentData;
import com.citiustech.pms.patient.model.PatientForm;
import com.citiustech.pms.patient.model.PatientVisit;
import com.citiustech.pms.patient.model.PatientsData;
import com.citiustech.pms.patient.service.PatientAppointmentService;
import com.citiustech.pms.patient.service.PatientDataService;
import com.citiustech.pms.patient.service.PatientRegistrationService;
import com.pms.user.entity.UserData;
import com.pms.user.service.AppointmentService;
import com.pms.user.service.UserDataService;

@RestController
@CrossOrigin(origins = "*")
public class PatientDataController {

	@Autowired
	PatientDataService patientService;

	@Autowired
	PatientRegistrationService patientRegistrationService;

	@Autowired
	private UserDataService userDataService;

	@Autowired
	PatientAppointmentService service;
	
	@Autowired
	AppointmentService appService;

	@GetMapping("patient/pmsDetails/appointment/{id}")
	public List<AppointmentData> getAppointmentsById(@PathVariable Integer id) throws RecordNotFoundException {
		return service.getAppointmentsByPatientId(id);
	}

	@RequestMapping(method = RequestMethod.POST, path = "patient/pmsDetails/scheduleMeeting", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public AppointmentData createOrUpdateAppointments(@RequestBody AppointmentData aData)
			throws RecordNotFoundException {
		return service.createAppointment(aData);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/patient/pmsDetails/patientDetails", consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Patient createPatient(@RequestBody PatientForm patient) throws Exception {
		return patientService.savePatient(patient);
	}

	@GetMapping(value = "patient/pmsDetails/patientDetails/{id}", produces = "application/json")
	public Patient fetchPatient(@PathVariable Integer id) {

		System.out.println(id);
		return patientService.getPatient(id);
	}

	@GetMapping(value = "patient/pmsDetails/patientVisitDetails/{id}", produces = "application/json")
	public PatientVisits fetchPatientVisit(@PathVariable Integer id) {

		System.out.println(id);
		if (id == -1)
			return PatientVisits.createEmptyVisit();
		PatientVisits visit = patientService.getPatientVisit(id);
		if (visit == null || visit.getVitalSigns() == null)
			return PatientVisits.createEmptyVisit();
		return visit;
	}

	@GetMapping(value = "patient/pmsDetails/patientByEmail/{emailId}", produces = "application/json")
	public Patient fetchPatientByEmailId(@PathVariable String emailId) {

		System.out.println(emailId);
		return patientService.getPatientByEmailId(emailId);
	}

	@GetMapping(value = "patient/pmsDetails/patientVisitByEmail/{emailId}", produces = "application/json")
	public Patient fetchPatientVisitByEmailId(@PathVariable String emailId) {

		System.out.println(emailId);
		return patientService.getPatientVisitByEmailId(emailId);
	}

	@RequestMapping(method = RequestMethod.POST, path = "patient/pmsDetails/patientVisitDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public PatientVisit createPatientVisit(@RequestBody PatientVisit patientvisit) {
		System.out.println(patientvisit);
		return patientService.savePatientVisit(patientvisit);
	}

//	@GetMapping(value = "patient/getAllPatientVisits")
//	public String fetchPatient() {
//		return patientService.getPatientVisits().toString();
//	}

	@GetMapping("patient/getAllPatients")
	public List<Patient> getAllPatients() {
		return patientService.getAllPatient();
	}

	@GetMapping("patient/getAllBlockedPatients")
	public List<Demographies> getAllBlockedPatients() {
		return patientService.getAllBlockedPatients();

	}

	@PostMapping(path = "/patient/pmsRegister/patientRegister", consumes = {
			MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> saveUser(PatientsData registerData) throws Exception {
		return ResponseEntity.ok(patientRegistrationService.save(registerData));
	}

	@RequestMapping(value = "/patient/fetchAllPatientData", method = RequestMethod.GET)
	@ResponseBody
	public List<Demographies> fetchAllPatient() throws Exception {
		return patientRegistrationService.fetchAllPatient();
	}

	@RequestMapping(value = "/patient/fetchAllBlockedPatientData", method = RequestMethod.GET)
	@ResponseBody
	public List<Demographies> fetchAllBLockedPatient() throws Exception {
		System.out.println("Inside patient");
		return patientRegistrationService.fetchAllBlockedPatient();
	}

	@RequestMapping(value = "/patient/fetchPatientData", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> fetchPatient(@RequestBody String emailId) throws Exception {
		return ResponseEntity.ok(patientRegistrationService.fetchPatient(emailId));
	}

	@RequestMapping(value = "/patient/overridePatientData", method = RequestMethod.POST)
	@ResponseBody
	public Demographies adminOverridePatient(@RequestBody Demographies demo) throws Exception {
		return patientRegistrationService.adminOverridePatient(demo);
	}

	@RequestMapping(value = "/patient/pmsDetails/fetchPhysicianData", method = RequestMethod.GET)
	@ResponseBody
	public List<UserData> fetchPhysicianData() throws Exception {
		return userDataService.getAllUserDataByRole("Physician");
	}
	@GetMapping("/patient/pmsDetails/appointment/slot")
	public List<String> getAllAvailableSlot(@RequestParam String date,@RequestParam String empId){
		return appService.getAllAvailableSlot(date,empId);
	}
	@GetMapping("/patient/stats/getPatientsStats")
	public List<Integer> getPatientsStats(){
		return patientService.getPatientStats();
	};
	
	@RequestMapping(value="/patient/rate&review",method = RequestMethod.POST,consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Appointment> getAppointment(@RequestBody Integer patientId) {
		return patientService.getAppointment(patientId);
	}

}
