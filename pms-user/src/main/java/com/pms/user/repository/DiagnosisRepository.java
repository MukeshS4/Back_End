package com.pms.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.user.entity.Diagnosis;

@Repository
public interface DiagnosisRepository extends CrudRepository<Diagnosis, String>{

}
