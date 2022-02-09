package com.pms.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.user.entity.PatientData;
import com.pms.user.entity.Procedure;

@Repository
public interface ProcedureRepository extends CrudRepository<Procedure ,String>{

}
