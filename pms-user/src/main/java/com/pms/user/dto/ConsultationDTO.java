package com.pms.user.dto;

import java.util.List;

import com.pms.user.entity.Medication;

public class ConsultationDTO {

	private List<DiagnosisDTO> diagnosisList;
	private List<Medication> medicationList;
	private List<ProcedureDTO> procedureList;
	public List<DiagnosisDTO> getDiagnosisList() {
		return diagnosisList;
	}
	public void setDiagnosisList(List<DiagnosisDTO> diagnosisList) {
		this.diagnosisList = diagnosisList;
	}
	public List<Medication> getMedicationList() {
		return medicationList;
	}
	public void setMedicationList(List<Medication> medicationList) {
		this.medicationList = medicationList;
	}
	public List<ProcedureDTO> getProcedureList() {
		return procedureList;
	}
	public void setProcedureList(List<ProcedureDTO> procedureList) {
		this.procedureList = procedureList;
	}
	
}
