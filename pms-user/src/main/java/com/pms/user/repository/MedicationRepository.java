package com.pms.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pms.user.entity.Medication;

@Repository
public interface MedicationRepository extends CrudRepository<Medication , String>{

}
