package com.citiustech.pms.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.citiustech.pms.patient.entity.PatientDiagnosis;

public interface PatientDiagnosisRepository extends JpaRepository<PatientDiagnosis, Integer> {

}
