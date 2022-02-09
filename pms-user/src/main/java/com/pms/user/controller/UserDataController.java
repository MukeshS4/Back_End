package com.pms.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.user.entity.UserData;
import com.pms.user.service.UserDataService;

@RestController
@RequestMapping("/user")
public class UserDataController {
	
	@Autowired
	private UserDataService userDataService;
	
	@GetMapping("/staff")
	public List<UserData> getAllUserData() {
		return userDataService.getAllUserData();
	}
	
	@GetMapping("/staff/role/{role}")
	public List<UserData> getAllPhysician(@PathVariable String role) {
		return userDataService.getAllUserDataByRole(role);
	}
	
//	@PostMapping("/staff")
//	public String createStaff(@RequestBody @Valid UserData userData) {
//		boolean flag=userDataService.saveStaffDetails(userData);
//		return flag==true?"User Created Successfully":"User already exists";
//	}
//	
//	@DeleteMapping("/staff/{emailId}")
//	public String deleteStaff(@PathVariable String emailId) {
//		userDataService.deleteUserDataByEmailId(emailId);
//		return "User deleted successfully";
//	}
	
	@GetMapping("/staff/{emailId}")
	public UserData getStaff(@PathVariable String emailId) {
		return userDataService.getUserDataByEmailId(emailId);
	}
	
	
	
//	@PutMapping("/staff")
//	public String updateStaff(@RequestBody UserData userData) {
//		boolean flag = userDataService.updateUserDataByEmailId(userData.getEmployeeId(), userData);
//		return flag==true?"User updated successfully":"user doesnot exists";
//	
//	
//	}
	
}
