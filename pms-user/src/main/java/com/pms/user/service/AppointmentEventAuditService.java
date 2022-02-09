package com.pms.user.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.user.dto.AppointmentEventAuditDTO;
import com.pms.user.entity.AppointmentEventAudit;
import com.pms.user.exception.AppointmentNotExistException;
import com.pms.user.repository.AppointmentEventAuditRepository;

@Service
public class AppointmentEventAuditService {
	
	@Autowired
	AppointmentEventAuditRepository appointmentEventAuditRepository;
	
	@Autowired
	private AppointmentService appointmentService;
	
	public List<AppointmentEventAudit> getAllAppointmentEventAudit(){
		List<AppointmentEventAudit> allAppointmentEventAudits = new ArrayList<>();
		appointmentEventAuditRepository.findAll().iterator().forEachRemaining(audit->{
			allAppointmentEventAudits.add(audit);
		});
		return allAppointmentEventAudits;
	}
	
	public AppointmentEventAudit getAppointmentEventAuditByAuditId(String auditId) {
		Optional<AppointmentEventAudit> appointmentEventAudit = null;
		appointmentEventAudit = appointmentEventAuditRepository.findById(auditId);
		return appointmentEventAudit.orElse(null);
	}
	
	public void createEventAudit(AppointmentEventAudit appointmentEventAudit) {
		try {
			appointmentEventAuditRepository.save(appointmentEventAudit);
		} catch (IllegalArgumentException e) {
			System.out.println("Exception while create event"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public List<AppointmentEventAuditDTO> getAllAppointmentEventAuditById(String id){
		try {
			List<AppointmentEventAudit> appointmentEventAudit=appointmentEventAuditRepository.findAllByAppointmentId(appointmentService.getAppointmentByAppointmentId(id));
			return appointmentEventAudit.stream().map(this::convertToEventAuditDTO).collect(Collectors.toList());
		} catch (AppointmentNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	private AppointmentEventAuditDTO convertToEventAuditDTO(AppointmentEventAudit appointmentEventAudit){
		return new AppointmentEventAuditDTO(appointmentEventAudit.getCreatedTs(),appointmentEventAudit.getModifiedBy().getFirstName().concat(" "+appointmentEventAudit.getModifiedBy().getLastName()),appointmentEventAudit.getReason());
	}

}
