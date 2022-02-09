package com.pms.user.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.user.constant.AppointmentStatus;
import com.pms.user.constant.TimeSlot;
import com.pms.user.dto.AppointmentDTO;
import com.pms.user.dto.AppointmentStats;
import com.pms.user.dto.EmailDTO;
import com.pms.user.dto.MessageDTO;
import com.pms.user.dto.PatientAppointmentConsultDTO;
import com.pms.user.entity.Appointment;
import com.pms.user.entity.AppointmentEventAudit;
import com.pms.user.entity.PatientData;
import com.pms.user.entity.UserData;
import com.pms.user.exception.AppointmentNotExistException;
import com.pms.user.repository.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private AppointmentEventAuditService appointmentEventAuditService;	
	
	@Autowired
	private NotificationClient notificationClient;
	
	@Autowired
	private UserDataService userDataService;
	
	@Autowired
	private PatientService patientDataService;
	
	@Autowired
	private ConsulationService consultationService;
		
	public boolean saveAppointmentDetails(AppointmentDTO appointmentDto) {
	boolean saveFlag = false;
	Appointment appointment=copyPropertiesFromDto(appointmentDto);
	if(appointment!=null) {
	try {
		appointment=appointmentRepository.save(appointment);
		notificationClient.sendEmail(new EmailDTO(appointment.getPatientData().getEmailId(),"Appointment Booked Successfully","Hi "+appointment.getPatientData().getFirstName()+", \r\nYour"
				+ "appointment has been Successfuly created. Please find below the appointment details :\r\n"
				+ "Appointment Id : "+appointment.getAppointmentId()+"\r\n"
						+ "Physician ID :"+appointment.getEmployee().getEmployeeId()+"\r\n"
								+ "Physician Name :"+appointment.getEmployee().getFirstName()+"\r\n"
										+ "Appointment Date and Time : "+appointment.getDate()+" "+appointment.getTime()));
		notificationClient.sendSMS(new MessageDTO(appointment.getPatientData().getContactNumber(),"Hi "+appointment.getPatientData().getFirstName()+" ,your appointment is booked for "+appointment.getDate()+" "+appointment.getTime()));
			saveFlag = true;
			
			notificationClient.sendEmail(new EmailDTO(appointment.getEmployee().getEmailId(),"Appointment Booked Successfully", "Hi "+appointment.getEmployee().getFirstName()+" "+appointment.getEmployee().getLastName()+",\r\n You"
					+"Booked an appointment. Plese find the below the appoinment details :\r\n"
					+ "Appoinment Id :"+appointment.getAppointmentId()+"\r\n"
					+"Physician Id :"+appointment.getEmployee().getEmployeeId()+"\r\n"
					+"Appointment Date and Time :"+appointment.getDate()+" "+appointment.getTime()+"\r\n"
					+"Patient Id : "+appointment.getPatientData().getId()+"\r\n"
					+"Patient Name :"+appointment.getPatientData().getFirstName()));
	} catch (IllegalArgumentException e) {
		System.out.println("Exception while saving the message into database"+e.getMessage());
		e.printStackTrace();
	}
	}
	return saveFlag;
	}
	
	public Appointment saveAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}
	
	private Appointment copyPropertiesFromDto(AppointmentDTO appointmentDto) {
		Appointment appointment;
		try {
			appointment = new Appointment();
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate localDate=LocalDate.parse(appointmentDto.getDate(),df);
			appointment.setDate(localDate);
			appointment.setDescription(appointmentDto.getDescription());
			appointment.setEmployee(appointmentDto.getEmployee());
			appointment.setPatientData(appointmentDto.getPatientData());
			appointment.setTime(appointmentDto.getTime());
			appointment.setStatus(appointmentDto.getStatus());
			appointment.setCreatedBy(userDataService.getUserDataByEmailId(appointmentDto.getCreatedByEmailId()).getEmployeeId());
			appointment.setCreatedTs(LocalDateTime.now());

			return appointment;
		} catch (IllegalArgumentException | DateTimeParseException e) {
			System.out.println("Exception while Parsing the Date and Time "+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public List<Appointment> getAllAppointment(){
		List<Appointment> allAppointment = new ArrayList<>();
		appointmentRepository.getAllAppointmentByStatus(Arrays.asList(AppointmentStatus.SCHEDULED.getStatus())).iterator().forEachRemaining(appointment->{
			allAppointment.add(appointment);
		});
		return allAppointment.stream().sorted(Comparator.comparing(Appointment::getDate).thenComparing(Appointment::getTime)).collect(Collectors.toList());
	}
	
	public List<Appointment> getAllAppointmentByStatusAndUser(String emailId,List<Integer> status){
		List<Appointment> allAppointment = new ArrayList<>();
		if(emailId==null)
		appointmentRepository.getAllAppointmentByStatus(status).iterator().forEachRemaining(appointment->{
			allAppointment.add(appointment);
		});
		else
		{
			UserData user=userDataService.getUserDataByEmailId(emailId);
			appointmentRepository.getAllAppointmentByStatusAndEmployee(status, user.getEmployeeId()).iterator().forEachRemaining(appointment->{
				allAppointment.add(appointment);
			});
		}
		return allAppointment.stream().sorted(Comparator.comparing(Appointment::getDate).thenComparing(Appointment::getTime)).collect(Collectors.toList());
	}
	
	public Appointment getAppointmentByAppointmentId(String appointmentId) throws AppointmentNotExistException {
		Optional<Appointment> appointment = null;
		try {
			appointment = appointmentRepository.findById(appointmentId);
		} catch (IllegalArgumentException e) {
			throw new AppointmentNotExistException("Appointment Does Not Exist for "+appointmentId);
		}
		return appointment.orElse(null);
	}
	
	public void cancelAppointmentByAppointmentId(String appointmentId,String reason) throws AppointmentNotExistException {
		try {
			Appointment appointment=getAppointmentByAppointmentId(appointmentId);
			appointment.setStatus(AppointmentStatus.CANCELLED.getStatus());
			appointmentRepository.save(appointment);
			notificationClient.sendEmail(new EmailDTO(appointment.getPatientData().getEmailId(),"Appointment Cancelled","Hi "+appointment.getPatientData().getFirstName()+", \r\nYour"
					+ "appointment has been Cancelled. Please find below the appointment details :\r\n"
					+ "Appointment Id : "+appointment.getAppointmentId()+"\r\n"
					+ "Reason : "+reason+"\r\n"
							+ "Physician ID :"+appointment.getEmployee().getEmployeeId()+"\r\n"
									+ "Physician Name :"+appointment.getEmployee().getFirstName()+"\r\n"
											+ "Appointment Date and Time : "+appointment.getDate()+" "+appointment.getTime()));
			notificationClient.sendSMS(new MessageDTO(appointment.getPatientData().getContactNumber(),"Hi "+appointment.getPatientData().getFirstName()+" ,your appointment is cancelled for "+appointment.getDate()+" "+appointment.getTime()));
			AppointmentEventAudit appointmentEventAudit=new AppointmentEventAudit(LocalDateTime.now(),appointment.getEmployee(),reason,appointment);
			appointmentEventAuditService.createEventAudit(appointmentEventAudit);
			
			notificationClient.sendEmail(new EmailDTO(appointment.getEmployee().getEmailId(),"Appointment Cancelled", "Hi "+appointment.getEmployee().getFirstName()+" "+appointment.getEmployee().getLastName()+",\r\n You"
					+"Just cancel an appointment. Plese find the below the appoinment details :\r\n"
					+ "Appoinment Id :"+appointment.getAppointmentId()+"\r\n"
					+"Physician Id :"+appointment.getEmployee().getEmployeeId()+"\r\n"
					+"Appointment Date and Time :"+appointment.getDate()+" "+appointment.getTime()+"\r\n"
					+"Patient Id : "+appointment.getPatientData().getId()+"\r\n"
					+"Patient Name :"+appointment.getPatientData().getFirstName()));
		} catch (IllegalArgumentException e) {
			System.out.println("Exception while cancelling the appointment"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public boolean updateAppointmentByAppointmentId(String appointmentId, AppointmentDTO appointmentDto) throws AppointmentNotExistException {
		boolean saveFlag = false;
		Appointment existingAppointment = getAppointmentByAppointmentId(appointmentId);
		if(existingAppointment==null) {
			throw new AppointmentNotExistException("Appointment Does Not Exist for "+appointmentId);
		}
		else
		{
			try {
				AppointmentEventAudit appointmentEventAudit=new AppointmentEventAudit(LocalDateTime.now(),appointmentDto.getEmployee(),existingAppointment.getDescription(),existingAppointment);
				DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate localDate=LocalDate.parse(appointmentDto.getDate(),df);
				existingAppointment.setDate(localDate);
				existingAppointment.setDescription(appointmentDto.getDescription());
				existingAppointment.setEmployee(appointmentDto.getEmployee());
				existingAppointment.setStatus(appointmentDto.getStatus());
				existingAppointment.setTime(appointmentDto.getTime());
				existingAppointment.setModifiedBy(userDataService.getUserDataByEmailId(appointmentDto.getCreatedByEmailId()).getEmployeeId());
				existingAppointment.setModifiedTs(LocalDateTime.now());
				appointmentRepository.save(existingAppointment);
				notificationClient.sendEmail(new EmailDTO(existingAppointment.getPatientData().getEmailId(),"Appointment Re-Scheduled Successfully","Hi "+existingAppointment.getPatientData().getFirstName()+", \r\nYour"
						+ "appointment has been re-scheduled. Please find below the appointment details :\r\n"
						+ "Appointment Id : "+existingAppointment.getAppointmentId()+"\r\n"
								+ "Physician ID :"+existingAppointment.getEmployee().getEmployeeId()+"\r\n"
										+ "Physician Name :"+existingAppointment.getEmployee().getFirstName()+"\r\n"
												+ "Appointment Date and Time : "+existingAppointment.getDate()+" "+existingAppointment.getTime()));
				notificationClient.sendSMS(new MessageDTO(existingAppointment.getPatientData().getContactNumber(),"Hi "+existingAppointment.getPatientData().getFirstName()+" ,your appointment is rescheduled for "+existingAppointment.getDate()+" "+existingAppointment.getTime()));
				appointmentEventAuditService.createEventAudit(appointmentEventAudit);
				saveFlag = true;
				
				notificationClient.sendEmail(new EmailDTO(existingAppointment.getEmployee().getEmailId(),"Appointment Re-Scheduled Successfully", "Hi "+existingAppointment.getEmployee().getFirstName()+" "+existingAppointment.getEmployee().getLastName()+",\r\n You"
						+"re-scheduled an appointment. Plese find the below the appoinment details :\r\n"
						+ "Appoinment Id :"+existingAppointment.getAppointmentId()+"\r\n"
						+"Physician Id :"+existingAppointment.getEmployee().getEmployeeId()+"\r\n"
						+"Appointment Date and Time :"+existingAppointment.getDate()+" "+existingAppointment.getTime()+"\r\n"
						+"Patient Id : "+existingAppointment.getPatientData().getId()+"\r\n"
						+"Patient Name :"+existingAppointment.getPatientData().getFirstName()));
			} catch (IllegalArgumentException | DateTimeParseException e) {
				System.out.println("Exception while updating the appointment"+e.getMessage());
				e.printStackTrace();
			}
			
			
		}
		return saveFlag;
	}
	
	public List<String> getAllAvailableSlot(String date,String empId){
		List<String> timeSlot = new ArrayList<>();
		try {
			UserData userData=userDataService.getUserDataByEmployeeId(empId);
			Arrays.asList(TimeSlot.values()).stream().forEach(slot->timeSlot.add(slot.getTimeSlot()));
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate localDate=LocalDate.parse(date,df);
			List<String> bookedSlot=appointmentRepository.getBookedSlotByDateAndStatusAndEmployee(localDate,AppointmentStatus.CANCELLED.getStatus(),userData);
			timeSlot.removeAll(bookedSlot);
		} catch (DateTimeParseException | IllegalArgumentException e) {
			System.out.println("Exception while checking for time slot"+e.getMessage());
			e.printStackTrace();
		}
		return timeSlot;
	}
	
	public List<Long> getAppointmentStats(String empId){
		List<Long> stats=new ArrayList<>();
		List<AppointmentStats> appointmentStats=new ArrayList<>();
		Map<Integer,Long> statsMap=new HashMap<>();
		if(empId==null)
		{
			appointmentStats=appointmentRepository.findAppointmentStats_Named();			
		}
		else
		{
			appointmentStats=appointmentRepository.findAppointmentStatsByEmployee_Named(userDataService.getUserDataByEmailId(empId));
		}
		statsMap=appointmentStats.stream().collect(Collectors.toMap(AppointmentStats::getStatus, AppointmentStats::getAppointmentCount));

		statsMap.putIfAbsent(AppointmentStatus.SCHEDULED.getStatus(), 0l);
		statsMap.putIfAbsent(AppointmentStatus.CREATED.getStatus(), 0l);
		statsMap.putIfAbsent(AppointmentStatus.COMPLETED.getStatus(), 0l);
		
		stats.add(statsMap.values().stream().reduce(0l, Long::sum));
		stats.add(statsMap.get(AppointmentStatus.SCHEDULED.getStatus()));
		stats.add(statsMap.get(AppointmentStatus.CREATED.getStatus()));
		stats.add(statsMap.get(AppointmentStatus.COMPLETED.getStatus()));
		return stats;
	}
	
	public List<Appointment> getAllAppointmentByUser(String emailId)
	{
		UserData user=userDataService.getUserDataByEmailId(emailId);
		List<Appointment> appointmentList=appointmentRepository.findAppointmentByEmployee(user);
		return appointmentList;
	}

	public List<Appointment> getAllAppointmentByDate(String date,String emailId)
	{
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate appointmentDate=date==null?LocalDate.now():LocalDate.parse(date,df);
		if(emailId==null)
		{
			return appointmentRepository.findAppointmentByDateAndStatus(appointmentDate,1);
		}
		else
		{
			UserData user=userDataService.getUserDataByEmailId(emailId);
			return appointmentRepository.findAppointmentByDateAndStatusAndEmployee(appointmentDate,1,user);
		}
	}
	
	public List<PatientAppointmentConsultDTO> getAllAppointmentConsultationByPatient(String emailId){
		List<PatientAppointmentConsultDTO> patientAppointmentConsultList=new ArrayList<>();
		PatientData patient=patientDataService.getPatientByEmailId(emailId);
		List<Appointment> patientAppointmentlist=appointmentRepository.findAppointmentByPatientDataAndStatus(patient,AppointmentStatus.COMPLETED.getStatus());
		patientAppointmentlist.parallelStream().forEach(appointment->{
			patientAppointmentConsultList.add(consultationService.getConsultation(appointment));
		});
		
		return patientAppointmentConsultList;
	}

	public List<Appointment> fetchPatientsAppointment(Integer patientId) {
		return appointmentRepository.findByPatientId(patientId);
	}
	
}
