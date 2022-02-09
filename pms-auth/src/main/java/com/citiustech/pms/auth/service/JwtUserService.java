package com.citiustech.pms.auth.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.citiustech.pms.auth.exception.AdminException;
import com.citiustech.pms.auth.exception.IncorrectEmailAddressException;
import com.citiustech.pms.auth.exception.UserAlreadyExistException;
import com.citiustech.pms.auth.exception.UserLockedException;
import com.citiustech.pms.auth.model.Login;
import com.citiustech.pms.auth.model.LoginDao;
import com.citiustech.pms.auth.model.LoginResponse;
import com.citiustech.pms.auth.model.PatientData;
import com.citiustech.pms.auth.model.RegistrationRate;
import com.citiustech.pms.auth.model.UserData;
import com.citiustech.pms.auth.model.UserDataDao;
import com.citiustech.pms.auth.repository.LoginRepository;
import com.citiustech.pms.auth.repository.RegistrationRateRepository;
import com.citiustech.pms.auth.repository.UserDataRepository;

@Service
public class JwtUserService implements UserDetailsService, IJwtUserService {
	
	@Autowired
	private RegistrationRateRepository regRepo;
	
	@Autowired
	private PmsPatientProxy pmsPatientProxy;

	@Autowired
	private MailService notificationService;

	@Autowired
	private LoginRepository loginRepo;

	@Autowired
	private UserDataRepository userRegistrationRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("HEYYYYYYYYY"+username);
		LoginDao user = loginRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		System.out.println("Hello : "+user);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	@Override
	public UserDataDao save(UserData registerData)
			throws MailException, UserAlreadyExistException, IncorrectEmailAddressException, AdminException {
		boolean exist = userExist(registerData.getEmailId());
		boolean admin = isAdmin(registerData.getRole());
		if (!exist && !admin) {
			UserDataDao newRegister = new UserDataDao();
			newRegister.setTitle(registerData.getTitle());
			newRegister.setFirstName(registerData.getFirstName());
			newRegister.setLastName(registerData.getLastName());
			newRegister.setEmailId(registerData.getEmailId());
			newRegister.setDateOfBirth(registerData.getDateOfBirth());
			newRegister.setDateofJoining(LocalDate.now());
			newRegister.setRole(registerData.getRole());
			newRegister.setEmployeeId(registerData.getEmployeeId());
			newRegister.setStatus(true);
			newRegister.setUnlocked(true);
			boolean sendEmail = emailNotification(registerData.getEmailId());
			if (!sendEmail) {
				throw new IncorrectEmailAddressException("Provided Email Id in incorrect or invalid");
			} else {
				try {
					RegistrationRate registrationRate = new RegistrationRate();
					registrationRate.setEmailId(registerData.getEmailId());
					registrationRate.setRegisteredDate(LocalDate.now());
					registrationRate.setRole(registerData.getRole());
					regRepo.save(registrationRate);
					saveLoginDetails(registerData);
					return userRegistrationRepo.save(newRegister);
				} catch (Exception E) {
					System.out.println(E);
					return null;
				}
			}
		} else {
			return null;
		}
	}

	@Override
	public LoginResponse getLoginData(String username) throws UserLockedException {
		UserDataDao regData = userRegistrationRepo.findByEmailId(username);
		if (regData == null) {
			PatientData pd = pmsPatientProxy.fetchPatient(username);
			if(pd == null) {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}else {
				LoginResponse loginRes1 = new LoginResponse();
				loginRes1.setEmailId(pd.getEmailId());
				loginRes1.setFirstName(pd.getFirstName());
				loginRes1.setLastName(pd.getLastName());
				loginRes1.setRole("Patient");
				loginRes1.setName(pd.getFirstName() +" "+ pd.getLastName());
				return loginRes1;
			}
			
		} else {
			if (!regData.isUnlocked()) {
				throw new UserLockedException("User's Account is Locked");
			} else {
				LoginResponse loginRes = new LoginResponse();
				loginRes.setEmailId(regData.getEmailId());
				loginRes.setFirstName(regData.getFirstName());
				loginRes.setLastName(regData.getLastName());
				loginRes.setRole(regData.getRole());
				loginRes.setName(regData.getFirstName() + regData.getLastName());
				return loginRes;
			}
		}
	}

	@Override
	public LoginDao saveLoginDetails(UserData registerData ) {
		LoginDao newLogin = new LoginDao();
		newLogin.setUsername(registerData.getEmailId());
		newLogin.setPassword(bcryptEncoder.encode("Password123"));
		newLogin.setRole(registerData.getRole());
		return loginRepo.save(newLogin);
	}

	@Override
	public boolean emailNotification(String email) throws IncorrectEmailAddressException {
		return notificationService.sendEmail(email);
	}

	@Override
	public boolean userExist(String email) throws UserAlreadyExistException {
		UserDataDao isUser = userRegistrationRepo.findByEmailId(email);
		if (isUser != null) {
			throw new UserAlreadyExistException("User is already Registered");
		} else {
			return false;
		}
	}
	
	@Override
	public boolean isAdmin(String role) throws AdminException {
		if(role == "Admin") {
			throw new AdminException("Only a single admin can persist");
		}else {
			return false;
		}
	}

	public Object savePatientLogin(Login loginData) {
		LoginDao newLogin = new LoginDao();
		newLogin.setUsername(loginData.getUsername());
		newLogin.setPassword(bcryptEncoder.encode(loginData.getPassword()));
		newLogin.setRole(loginData.getRole());
		
		RegistrationRate registrationRate = new RegistrationRate();
		registrationRate.setEmailId(loginData.getUsername());
		registrationRate.setRegisteredDate(LocalDate.now());
		registrationRate.setRole(loginData.getRole());
		regRepo.save(registrationRate);
		
		return loginRepo.save(newLogin);
	}
}
