package com.citiustech.pms.patient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citiustech.pms.patient.entity.Demographies;

@Repository
public interface DemographyRepository extends JpaRepository<Demographies, Integer>  {

	List<Demographies> findByEmail(String email);
	
	@Query(value="Select * from demographies d where d.unlock=true", nativeQuery=true)
	List<Demographies> findAllUnBlocked();
	
	@Query(value="Select * from demographies d where d.unlock=false", nativeQuery=true)
	List<Demographies> findAllBlocked();
	
	@Query(value="SELECT COUNT(*) FROM demographies d", nativeQuery=true)
	int getAllPatientsCount();
	
	@Query(value="SELECT COUNT(*) FROM demographies d where d.unlock=false", nativeQuery=true)
	int getAllPatientsLockedCount();
	
	@Query(value="SELECT COUNT(*) FROM demographies d where d.status=false", nativeQuery=true)
	int getAllPatientsInActiveCount();
	
	
}
