package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.dto.LoginDto;
import com.lti.repository.LoginRepository;
import com.lti.service.exception.LoginException;

public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public int loginAdminAndCustomer(LoginDto loginDto) throws LoginException {
		// TODO Auto-generated method stub
		if (loginDto.getUserType().equals("Admin")) {
			if (loginRepository.isAdminAvalable(loginDto.getUsername())) {
				if (loginRepository.isAdminPasswordCorrect(loginDto.getPassword(), loginDto.getUsername())) {
					return loginRepository.adminUserLogin(loginDto.getUsername(), loginDto.getPassword());
				} else {
					throw new LoginException("Password Incorrect");
				}

			} else {
				throw new LoginException("Username Incorrect");
			}

		} else {
			if (loginRepository.isCustomerAvalable(loginDto.getUsername())) {
				if (loginRepository.isCustomerPasswordCorrect(loginDto.getPassword(), loginDto.getUsername())) {
					return loginRepository.customerUserLogin(loginDto.getUsername(), loginDto.getPassword());
				} else {
					throw new LoginException("Password Incorrect");
				}
			} else {
				throw new LoginException("Username Incorrect");
			}

		}

	}

}
