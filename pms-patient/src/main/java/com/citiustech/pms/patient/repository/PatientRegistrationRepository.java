package com.citiustech.pms.patient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citiustech.pms.patient.entity.Patient;

import com.citiustech.pms.patient.entity.PatientRegistrationData;

@Repository
public interface PatientRegistrationRepository extends  JpaRepository<PatientRegistrationData, Integer>{

PatientRegistrationData findByEmailId(String emailId);
	
	PatientRegistrationData deleteByEmailId(String emailId);
	@Query(value="Select * from Patient.Data pd where ", nativeQuery=true)
	List<PatientRegistrationData> findAllBlocked();
	
	@Query(value="Select pd.id from Patient.Data pd ", nativeQuery=true)
	List<String> extractId();
	
}
