package com.pms.user.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.user.constant.AppointmentStatus;
import com.pms.user.dto.ConsultationDTO;
import com.pms.user.dto.DiagnosisDTO;
import com.pms.user.dto.PatientAppointmentConsultDTO;
import com.pms.user.dto.ProcedureDTO;
import com.pms.user.entity.Appointment;
import com.pms.user.entity.AppointmentDiagnosis;
import com.pms.user.entity.AppointmentDiagnosisId;
import com.pms.user.entity.AppointmentMedication;
import com.pms.user.entity.AppointmentMedicationId;
import com.pms.user.entity.AppointmentProcedure;
import com.pms.user.entity.AppointmentProcedureId;
import com.pms.user.entity.Medication;
import com.pms.user.exception.AppointmentNotExistException;
import com.pms.user.repository.AppointmentDiagnosisRepository;
import com.pms.user.repository.AppointmentMedicationRepository;
import com.pms.user.repository.AppointmentProcedureRepository;

@Service
public class ConsulationService {

	@Autowired
	private AppointmentProcedureRepository appointmentProcedureRepository;
	
	@Autowired
	private AppointmentDiagnosisRepository appointmentDiagnosisRepository;
	
	@Autowired
	private AppointmentMedicationRepository appointmentMedicationRepository;
	
	@Autowired
	private AppointmentService appointmentService;
	
	public String createConsultation(ConsultationDTO consultationDto,String appointmentId) {
		try {
			Appointment appointment=appointmentService.getAppointmentByAppointmentId(appointmentId);
			consultationDto.getDiagnosisList().forEach(diagnosis->{
				appointmentDiagnosisRepository.save(new AppointmentDiagnosis(new AppointmentDiagnosisId(appointment,diagnosis.getDiagnosis()),diagnosis.getIsDepricated()));
			});
			consultationDto.getProcedureList().forEach(procedure->{
				appointmentProcedureRepository.save(new AppointmentProcedure(new AppointmentProcedureId(appointment,procedure.getProcedure()),procedure.getIsDepricated()));
			});
			
			consultationDto.getMedicationList().forEach(medication->{
				appointmentMedicationRepository.save(new AppointmentMedication(new AppointmentMedicationId(appointment,medication)));
			});
			appointment.setStatus(AppointmentStatus.COMPLETED.getStatus());
			appointmentService.saveAppointment(appointment);
		} catch (AppointmentNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	public PatientAppointmentConsultDTO getConsultation(Appointment appointment) {
		PatientAppointmentConsultDTO consultation=new PatientAppointmentConsultDTO();
		consultation.setDiagnosis(appointmentDiagnosisRepository.findAppointmentDiagnosisByAppointment(appointment).stream().map(this::convertToDiagnosisDTO).collect(Collectors.toList()));
		consultation.setAppointment(appointment);
		consultation.setMedication(appointmentMedicationRepository.findAppointmentMedicationByAppointment(appointment).stream().map(this::convertToMedication).collect(Collectors.toList()));
		consultation.setProcedure(appointmentProcedureRepository.findAppointmentProcedureByAppointment(appointment).stream().map(this::convertToProcedureDTO).collect(Collectors.toList()));
		return consultation;
		
	}
	
	private DiagnosisDTO convertToDiagnosisDTO(AppointmentDiagnosis diagnosis) {
		return new DiagnosisDTO(diagnosis.getAppointmentDiagnosiId().getDiagnosisId(),diagnosis.isDepricated());
	}
	
	private ProcedureDTO convertToProcedureDTO(AppointmentProcedure procedure) {
		return new ProcedureDTO(procedure.getAppointmentProcedureId().getProcedureId(),procedure.isDepricated());
	}
	
	private Medication convertToMedication(AppointmentMedication medication) {
		return medication.getAppointmentMedicationId().getMedicationId();
	}
}
