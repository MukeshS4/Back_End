package com.pms.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.user.entity.PatientData;

@Repository
public interface PatientDataRepository extends CrudRepository<PatientData,String> {

	PatientData findPatientDataByEmailId(String emailId);
}
