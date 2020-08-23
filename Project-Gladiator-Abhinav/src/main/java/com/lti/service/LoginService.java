package com.lti.service;

import com.lti.dto.LoginDto;
import com.lti.service.exception.LoginException;

public interface LoginService {

	int loginAdminAndCustomer(LoginDto loginDto) throws LoginException;

}
