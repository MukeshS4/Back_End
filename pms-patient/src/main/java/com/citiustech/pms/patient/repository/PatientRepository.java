package com.citiustech.pms.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citiustech.pms.patient.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>  {

//	@Query("SELECT a.email from Demographies a")
//	public Patient findEmail(String email);
}
