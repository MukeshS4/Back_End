package com.citiustech.pms.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.pms.patient.entity.EmergencyContactDetails;
import com.citiustech.pms.patient.entity.Patient;

public interface EmergencyContactRepository extends JpaRepository<EmergencyContactDetails, Integer>  {

}
