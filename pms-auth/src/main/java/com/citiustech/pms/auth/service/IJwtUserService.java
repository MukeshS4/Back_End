package com.citiustech.pms.auth.service;


import org.springframework.mail.MailException;

import com.citiustech.pms.auth.exception.AdminException;
import com.citiustech.pms.auth.exception.IncorrectEmailAddressException;
import com.citiustech.pms.auth.exception.UserAlreadyExistException;
import com.citiustech.pms.auth.exception.UserLockedException;
import com.citiustech.pms.auth.model.LoginDao;
import com.citiustech.pms.auth.model.LoginResponse;
import com.citiustech.pms.auth.model.UserData;
import com.citiustech.pms.auth.model.UserDataDao;

public interface IJwtUserService {

	public UserDataDao save(UserData registerData) throws MailException, UserAlreadyExistException, IncorrectEmailAddressException, AdminException;
	
	public LoginResponse getLoginData(String username) throws UserLockedException;
	
	public LoginDao saveLoginDetails(UserData registerData);

	public boolean emailNotification(String email) throws IncorrectEmailAddressException; 

	public boolean userExist(String email) throws UserAlreadyExistException;

	boolean isAdmin(String role) throws AdminException;
	

}
