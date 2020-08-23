package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.LoginDto;
import com.lti.entity.Admin;
import com.lti.entity.Customer;
import com.lti.repository.LoginRepository;
import com.lti.service.exception.LoginException;
import com.lti.status.LoginReturnStatus;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Override

	public LoginReturnStatus loginAdmin(LoginDto loginDto) throws LoginException {
		if (loginRepository.isAdminAvalable(loginDto.getUsername())) {
			if (loginRepository.isAdminPasswordCorrect(loginDto.getPassword(), loginDto.getUsername())) {
				Admin admin = loginRepository.adminUserLogin(loginDto.getUsername(), loginDto.getPassword());

				LoginReturnStatus loginReturnStatus = new LoginReturnStatus();
				loginReturnStatus.setUserId(admin.getId());
				loginReturnStatus.setActiveStatus(true);
				loginReturnStatus.setDocumentUploadedStatus(true);
				loginReturnStatus.setUserType(loginDto.getUserType());
				loginReturnStatus.setStatus(100);
				loginReturnStatus.setMessage("Logged in Successfully");

				return loginReturnStatus;
			} else {
				throw new LoginException("Password Incorrect");
			}

		} else {
			throw new LoginException("Username or Password Incorrect");
		}
	}

	public LoginReturnStatus loginCustomer(LoginDto loginDto) throws LoginException {
		if (loginRepository.isCustomerAvalable(loginDto.getUsername())) {
			if (loginRepository.isCustomerPasswordCorrect(loginDto.getPassword(), loginDto.getUsername())) {
				Customer customer = loginRepository.customerUserLogin(loginDto.getUsername(), loginDto.getPassword());
				
				LoginReturnStatus loginReturnStatus = new LoginReturnStatus();
				
				loginReturnStatus.setUserId(customer.getId());
				loginReturnStatus.setUserType(loginDto.getUserType());
				loginReturnStatus.setStatus(100);
				loginReturnStatus.setMessage("Logged in Successfully");
				loginReturnStatus.setActiveStatus(loginRepository.customerActiveStatus(customer.getId()));
				loginReturnStatus.setDocumentUploadedStatus(loginRepository.hasCustomerUploadedDocument(customer.getId()));
				
				return loginReturnStatus;		
				
			} else {
				throw new LoginException("Password Incorrect");
			}
		} else {
			throw new LoginException("Username or Password Incorrect");
		}
	}

}
