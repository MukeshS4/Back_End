package com.citiustech.pms.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.pms.patient.entity.PatientMedication;



public interface PatientMedicationRepository extends JpaRepository<PatientMedication, Integer> {

}
