package com.lti.service;

import com.lti.dto.LoginDto;

public interface LoginService {

	int loginAdminAndCustomer(LoginDto loginDto) throws LoginException;

}
