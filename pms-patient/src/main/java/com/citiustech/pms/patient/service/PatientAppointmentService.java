package com.citiustech.pms.patient.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.citiustech.pms.patient.entity.Patient;
import com.citiustech.pms.patient.entity.PatientAppointment;
import com.citiustech.pms.patient.model.AppointmentData;
import com.citiustech.pms.patient.repository.AppointmentsRepository;
import com.citiustech.pms.patient.repository.PatientRepository;
import com.pms.user.entity.UserData;
import com.pms.user.repository.UserDataRepository;

@Service
public class PatientAppointmentService {

	@Autowired
	AppointmentsRepository repository;
	
	@Autowired
	PatientRepository patientRepo;

	@Autowired
	UserDataRepository userRepo;

	public List<AppointmentData> getAppointmentsByPatientId(Integer id) {
		if(id==null)
			return new ArrayList<>();
		Optional<Patient> patient = patientRepo.findById(id);
		if(patient.isPresent())
		{
			List<AppointmentData> list = new ArrayList<>();
			patient.get().getAppointments().forEach(a->list.add(AppointmentData.createAppointment(a)));
			return list;
		}
		return new ArrayList<>();
	}
	
	public AppointmentData createAppointment(AppointmentData appointment)
	{
		Integer patientId = appointment.getPatientId();
		Optional<Patient> patientOpt = patientRepo.findById(patientId);
		if(patientOpt.isPresent())
		{
			Patient patient = patientOpt.get();
			Set<PatientAppointment> appList = patient.getAppointments();
			PatientAppointment app = new PatientAppointment();
			app.setPatient(patient);
			app.setCreatedBy(patient.getDemographies().getFirst_name());
			app.setCreatedTs(LocalDateTime.now());
			app.setTime(appointment.getTime());
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate localDate=LocalDate.parse(appointment.getDate(),df);
			app.setDate(localDate);
			app.setDescription(appointment.getDescription());
			Optional<UserData> empl = userRepo.findById(appointment.getPhysicianId());
			if(empl.isPresent())
				app.setEmployee(empl.get());
			appList.add(app);
			patientRepo.save(patient);
			return AppointmentData.createAppointment(app);
		}
		return null;
	}
}
