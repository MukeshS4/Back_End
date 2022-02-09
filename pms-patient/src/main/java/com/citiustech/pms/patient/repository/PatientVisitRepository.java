package com.citiustech.pms.patient.repository;

import org.hibernate.mapping.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citiustech.pms.patient.entity.PatientVisits;

public interface PatientVisitRepository extends JpaRepository<PatientVisits, Integer>{
	
//	@Query(" FROM PatientVisits pv left join Diagnosis ds on pv.id= ds.patientVisitId"
//			+ " left join VitalSigns vs on pv.vitalSignsId = vs.id "
//			+ " left join Procedure pr on pv.id = pr.patientVisitId "
//			+ " left join Medication md on pv.id =md.patientVisitId ")
//	public	Collection findAllPatientVisits();

}
