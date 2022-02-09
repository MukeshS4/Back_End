package com.citiustech.pms.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.pms.auth.exception.IdenticalPasswordException;
import com.citiustech.pms.auth.exception.PasswordMismatchException;
import com.citiustech.pms.auth.model.ChangePassword;
import com.citiustech.pms.auth.model.Demographies;
import com.citiustech.pms.auth.model.UserDataDao;
import com.citiustech.pms.auth.service.AuthService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@SecurityRequirement(name = "PMS")
public class AuthController {
	
//	 private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
//	@Autowired
//	private Environment en;
	
	@Autowired
	AuthService authService;
	
	@RequestMapping(value = "/PMS/pmsStatus/getRegistrationRate", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getRegistrationRate(){
		return ResponseEntity.ok(authService.getRegistrationRate());
	}

	@RequestMapping(value = "/PMS/pmsStatus/getStatistics", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getStatistics(){
		return ResponseEntity.ok(authService.getStatistics());
	}
	@ApiOperation(value="Change your password",response= ChangePassword.class)
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Password changed successfully"),
			@ApiResponse(code=401, message="You are not Authorized to view this resource"),
			@ApiResponse(code=403, message="Accessing this resource is forbidden"),
			@ApiResponse(code=404, message="The  resource your trying to reach is not found")
			
	})
	@RequestMapping(value = "/PMS/pmsPassword/changePassword", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> changePassword(@RequestBody ChangePassword passwordData) throws IdenticalPasswordException, PasswordMismatchException {
		return ResponseEntity.ok(authService.updatePassword(passwordData));
	}
	
	@ApiOperation(value="Lock Account - Admin Override",response= UserDataDao.class)
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Account has been locked successfully "),
			@ApiResponse(code=401, message="You are not Authorized to view this resource"),
			@ApiResponse(code=403, message="Accessing this resource is forbidden"),
			@ApiResponse(code=404, message="The  resource your trying to reach is not found")
			
	})
	@RequestMapping(value = "/PMS/pmsLock/lockAccount", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> lockAccount(@RequestBody String username) {
		return ResponseEntity.ok(authService.lockAccount(username));
	}
	
	@ApiOperation(value="Unlock Account - Admin Override",response= UserDataDao.class)
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Account has been unlocked successfully "),
			@ApiResponse(code=401, message="You are not Authorized to view this resource"),
			@ApiResponse(code=403, message="Accessing this resource is forbidden"),
			@ApiResponse(code=404, message="The  resource your trying to reach is not found")
			
	})
	@RequestMapping(value = "/PMS/pmsLock/unLockAccount", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> unLockAccount(@RequestBody String username) {
		System.out.println("hit Lock");
		return ResponseEntity.ok(authService.unLockAccount(username));
	}
	
	@ApiOperation(value="De-Activate Account - Admin Override",response= UserDataDao.class)
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Account has been De-Activated successfully "),
			@ApiResponse(code=401, message="You are not Authorized to view this resource"),
			@ApiResponse(code=403, message="Accessing this resource is forbidden"),
			@ApiResponse(code=404, message="The  resource your trying to reach is not found")
			
	})
	@RequestMapping(value = "/PMS/pmsStatus/deactivateAccount", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> deactivateAccount(@RequestBody String emailId) {
		return ResponseEntity.ok(authService.deActivateAccount(emailId));
	}
	
	@ApiOperation(value="Force Activate Account - Admin Override",response= UserDataDao.class)
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Account has been Activated successfully "),
			@ApiResponse(code=401, message="You are not Authorized to view this resource"),
			@ApiResponse(code=403, message="Accessing this resource is forbidden"),
			@ApiResponse(code=404, message="The  resource your trying to reach is not found")
			
	})
	@RequestMapping(value = "/PMS/pmsStatus/activateAccount", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> activateAccount(@RequestBody String emailId) {
		return ResponseEntity.ok(authService.activateAccount(emailId));
	}
	
	@ApiOperation(value="Force Patient Account - Admin Override",response= UserDataDao.class)
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Account has been modified successfully by forcing admin rights"),
			@ApiResponse(code=401, message="You are not Authorized to view this resource"),
			@ApiResponse(code=403, message="Accessing this resource is forbidden"),
			@ApiResponse(code=404, message="The  resource your trying to reach is not found")
			
	})
	@RequestMapping(value = "/PMS/pmsLock/overridePatient", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> overridePatient(@RequestBody Demographies demo) {
		return ResponseEntity.ok(authService.overrideAccount(demo));
	}

	@ApiOperation(value="Fetch all User's Data",response=UserDataDao.class)
	@ApiResponses(value= {
			@ApiResponse(code=201, message="All User's Data"),
			@ApiResponse(code=401, message="You are not Authorized to view this resource"),
			@ApiResponse(code=403, message="Accessing this resource is forbidden"),
			@ApiResponse(code=404, message="The  resource your trying to reach is not found")
			
	})
	@RequestMapping(value = "/PMS/pmsGet/getAllUsers", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllUsers() throws Exception {
		return ResponseEntity.ok(authService.getAllUsers());
	}
	
	@ApiOperation(value="Fetch all blocked User's Data",response=UserDataDao.class)
	@ApiResponses(value= {
			@ApiResponse(code=201, message="All blocked User's Data"),
			@ApiResponse(code=401, message="You are not Authorized to view this resource"),
			@ApiResponse(code=403, message="Accessing this resource is forbidden"),
			@ApiResponse(code=404, message="The  resource your trying to reach is not found")
			
	})
	@RequestMapping(value = "/PMS/pmsGet/getAllBockedUsers", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllBlockedUsers() throws Exception {
		return ResponseEntity.ok(authService.getAllBlockedUsers());
	}
	
	@ApiOperation(value="Fetch all Patient's Data",response=Demographies.class)
	@ApiResponses(value= {
			@ApiResponse(code=201, message="All Patient's Data"),
			@ApiResponse(code=401, message="You are not Authorized to view this resource"),
			@ApiResponse(code=403, message="Accessing this resource is forbidden"),
			@ApiResponse(code=404, message="The  resource your trying to reach is not found")
			
	})
	@RequestMapping(value = "/PMS/pmsGet/getAllPatients", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllPatients() throws Exception {
		return ResponseEntity.ok(authService.getAllPatients());
	}
	
	@ApiOperation(value="Fetch all blocked Patient's Data",response=Demographies.class)
	@ApiResponses(value= {
			@ApiResponse(code=201, message="All blocked Patient's Data"),
			@ApiResponse(code=401, message="You are not Authorized to view this resource"),
			@ApiResponse(code=403, message="Accessing this resource is forbidden"),
			@ApiResponse(code=404, message="The  resource your trying to reach is not found")
			
	})
	@RequestMapping(value = "/PMS/pmsGet/getAllBockedPatients", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllBlockedPatients() throws Exception {
		return ResponseEntity.ok(authService.getAllBlockedPatients());
	}
	
	@RequestMapping(value = "/PMS/pmsDelete/deleteUser", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> deleteUser(@RequestBody String emailId) throws Exception {
		return ResponseEntity.ok(authService.deleteUser(emailId));
	}
	
	@RequestMapping(value = "/PMS/pmsGet/getEmployeeId", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getUniqueEmployeeId() {
		System.out.println("Hi");
		return ResponseEntity.ok(authService.getUniqueEmployeeId());
	}
	
	@RequestMapping(value = "/PMS/pmsPassword/forgotPassword", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> forgotPassword(@RequestBody String emailId) {
		return ResponseEntity.ok(authService.deleteUser(emailId));
	}
	
}
