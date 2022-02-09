package com.citiustech.pms.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.pms.patient.entity.Allergies;

public interface AllergiesRepository extends JpaRepository<Allergies, Integer>  {

}
