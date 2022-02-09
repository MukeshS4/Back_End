package com.citiustech.pms.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citiustech.pms.auth.model.UserDataDao;

@Repository
public interface UserDataRepository extends JpaRepository<UserDataDao, Integer> {
	
	UserDataDao findByEmailId(String emailId);
	
	UserDataDao deleteByEmailId(String emailId);
	@Query(value="Select * from user_data ud where ud.unlocked=false", nativeQuery=true)
	List<UserDataDao> findAllBlocked();
	
	@Query(value="Select ud.employee_id from user_data ud ", nativeQuery=true)
	List<String> extractId();
	
	@Query(value="SELECT COUNT(*) FROM user_data ud where ud.role='Physician'", nativeQuery=true)
	int getAllUsersCountPhysician();
	
	@Query(value="SELECT COUNT(*) FROM user_data ud where ud.role='Physician' AND ud.status=false ", nativeQuery=true)
	int getAllUsersInActiveCountPhysician();
	
	@Query(value="SELECT COUNT(*) FROM user_data ud where ud.unlocked=false", nativeQuery=true)
	int getAllUsersLockedCount();
	
	@Query(value="SELECT COUNT(*) FROM user_data ud where ud.role='Nurse'", nativeQuery=true)
	int getAllUsersCountNurse();
	
	@Query(value="SELECT COUNT(*) FROM user_data ud where ud.role='Nurse' AND ud.status=false  ", nativeQuery=true)
	int getAllUsersInActiveCountNurse();

}
