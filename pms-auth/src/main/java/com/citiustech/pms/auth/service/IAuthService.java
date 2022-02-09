package com.citiustech.pms.auth.service;

import java.util.List;

import com.citiustech.pms.auth.exception.IdenticalPasswordException;
import com.citiustech.pms.auth.exception.PasswordMismatchException;
import com.citiustech.pms.auth.exception.UserNotFoundException;
import com.citiustech.pms.auth.model.ChangePassword;
import com.citiustech.pms.auth.model.Demographies;
import com.citiustech.pms.auth.model.UserDataDao;

public interface IAuthService {
	
	public Object updatePassword(ChangePassword passwordData) throws IdenticalPasswordException, PasswordMismatchException;
	public Object lockAccount(String username);
	public List<UserDataDao> getAllUsers();
	public boolean deleteUser(String emailId);
	public Object deActivateAccount(String emailId);
	public Object activateAccount(String emailId);
	public Object getAllBlockedUsers();
	public Object unLockAccount(String username);
	public List<String> getUniqueEmployeeId();
	public boolean forgotPassword(String username) throws UserNotFoundException;
	List<Demographies> getAllPatients();
	List<Demographies> getAllBlockedPatients();
	Object overrideAccount(Demographies demo);
	Object getStatistics();

}
