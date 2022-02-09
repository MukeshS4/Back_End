package com.pms.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.user.dto.AppointmentDTO;
import com.pms.user.dto.PatientAppointmentConsultDTO;
import com.pms.user.entity.Appointment;
import com.pms.user.exception.AppointmentNotExistException;
import com.pms.user.service.AppointmentService;

@RestController
@RequestMapping("/user")
public class AppointmentController {
	
	private static Logger logger = LogManager.getLogger();
	
	@Autowired
	private AppointmentService appointmentService;
	
	@GetMapping("/appointment")
	public List<Appointment> getAllAppointment(HttpServletRequest request){
		 logger.info(request.getHeader("User-Agent"));
		return appointmentService.getAllAppointment();
	}
	
	@PostMapping("/appointment")
	public String createAppointment(@RequestBody @Valid AppointmentDTO appointmentDto) {
		boolean flag = appointmentService.saveAppointmentDetails(appointmentDto);
		return flag==true?"Appointment Scheduled Successfully":"Appointment Alredy Scheduled";
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/appointment/{appointmentId}")
	public String cancelAppointment(@PathVariable String appointmentId,@RequestParam String reason) throws AppointmentNotExistException {
		appointmentService.cancelAppointmentByAppointmentId(appointmentId,reason);
		return "Appointment Deleted Successfully";
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/appointment")
	public String modifyAppointment(@RequestBody @Valid AppointmentDTO appointment) throws AppointmentNotExistException {
		boolean flag = appointmentService.updateAppointmentByAppointmentId(appointment.getAppointmentId(), appointment);
		return flag==true?"Appointment Updated Successfully":"Appointment Doesnot Exists";
	}
	
	@GetMapping("/appointment/{appointmentId}")
	public Appointment getAppointment(@PathVariable String appointmentId) throws AppointmentNotExistException {
		return appointmentService.getAppointmentByAppointmentId(appointmentId);
	}
	
	@GetMapping("/appointment/slot")
	public List<String> getAllAvailableSlot(@RequestParam String date,@RequestParam String empId){
		return appointmentService.getAllAvailableSlot(date,empId);
	}
	
	@GetMapping("/appointment/stats")
	public List<Long> getAppointmentStats(@RequestParam(required=false) String empId){
		return appointmentService.getAppointmentStats(empId);
	}
	
	@GetMapping("/appointment/user/{emailId}")
	public List<Appointment> getAllAppointmentByUser(@PathVariable String emailId){
		return appointmentService.getAllAppointmentByUser(emailId);
	}
	
	@GetMapping("/appointment/date")
	public List<Appointment> getAllAppointmentByDate(@RequestParam(required=false) String date,@RequestParam(required=false) String emailId){
		return appointmentService.getAllAppointmentByDate(date,emailId);
	}
	
	@PostMapping("/appointment/status")
	public List<Appointment> getAllAppointmentByStatusAndUser(@RequestParam(required=false) String emailId,@RequestBody List<Integer> status){
		return appointmentService.getAllAppointmentByStatusAndUser(emailId,status);
	}
	
	@GetMapping("/appointment/patient/{emailId}/consultation")
	public List<PatientAppointmentConsultDTO> getAllAppointmentConsultationByPatient(@PathVariable String emailId){
		return appointmentService.getAllAppointmentConsultationByPatient(emailId);
	}
	
	@GetMapping("/getAppointment")
	List<Appointment> fetchAppointment(@RequestBody Integer patientId){
		return appointmentService.fetchPatientsAppointment(patientId);
	}

}
