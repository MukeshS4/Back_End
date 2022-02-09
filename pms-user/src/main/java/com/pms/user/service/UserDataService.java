package com.pms.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.user.entity.UserData;
import com.pms.user.repository.UserDataRepository;

@Service
public class UserDataService {
	
	@Autowired
	UserDataRepository userDataRepository;
	
	/*
	 * public boolean saveStaffDetails(UserData staff) { boolean saveFlag=false;
	 * UserData existingStaff = getUserDataByEmployeeId(staff.getEmployeeId());
	 * if(existingStaff==null) { userDataRepository.save(staff); saveFlag=true; }
	 * return saveFlag; }
	 */
	
	public List<UserData> getAllUserDataByRole(String role)
	{
		List<UserData> allUserData = getAllUserData();
		allUserData = allUserData.stream().filter(staff->staff.getRole().equals(role)).collect(Collectors.toList());
		return allUserData;
	}
	
	public List<UserData> getAllUserData(){
		List<UserData> allUserData = new ArrayList<>();
		userDataRepository.findAll().iterator().forEachRemaining(staff->{
			allUserData.add(staff);
		});
		return allUserData;
	}
	
	public UserData getUserDataByEmployeeId(String employeeId) {
		Optional<UserData> userData = null;
		userData = userDataRepository.findById(employeeId);
		return userData.orElse(null);
	}
	
	public UserData getUserDataByEmailId(String emailId) {
		Optional<UserData> userData = null;
		userData = userDataRepository.findByEmailId(emailId);
		return userData.orElse(null);
	}
	
	/*
	 * public void deleteUserDataByEmailId(String emailId) {
	 * userDataRepository.deleteById(emailId); }
	 * 
	 * public boolean updateUserDataByEmailId(String employeeId, UserData
	 * userData) { boolean saveFlag=false; UserData existingStaff =
	 * getUserDataByEmployeeId(employeeId); if(existingStaff!=null) {
	 * userDataRepository.save(userData); saveFlag=true; } return saveFlag; }
	 */

}
