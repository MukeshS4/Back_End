package com.citiustech.pms.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citiustech.pms.auth.model.MonthCount;
import com.citiustech.pms.auth.model.RegistrationRate;

public interface RegistrationRateRepository extends JpaRepository<RegistrationRate, Integer>{
	
	@Query(value="select new com.citiustech.pms.auth.model.MonthCount(EXTRACT(month from registeredDate) as dateCount, count(*) as count) \r\n" + 
			"from RegistrationRate where role='Physician' group by EXTRACT(month from registeredDate) order by EXTRACT(month from registeredDate)")
	List<MonthCount> physicianRegistrationCountByMonth();

}
