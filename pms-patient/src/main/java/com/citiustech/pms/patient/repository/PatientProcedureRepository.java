package com.citiustech.pms.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.pms.patient.entity.PatientProcedure;



public interface PatientProcedureRepository extends JpaRepository<PatientProcedure, Integer>{

}
