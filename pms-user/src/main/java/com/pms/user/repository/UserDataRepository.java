package com.pms.user.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.user.entity.UserData;

@Repository
public interface UserDataRepository extends CrudRepository<UserData, String> {

	Optional<UserData> findByEmailId(String emailId);
}
