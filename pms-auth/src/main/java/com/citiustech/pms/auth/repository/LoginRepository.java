package com.citiustech.pms.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.citiustech.pms.auth.model.LoginDao;

@Repository
public interface LoginRepository extends JpaRepository<LoginDao, Integer> {
	
	LoginDao findByUsername(String username);
	
	@Query(value="delete from user_login ul where ul.username=:username ", nativeQuery=true)
	boolean deleteByUserName(@Param("username")String username);

}
