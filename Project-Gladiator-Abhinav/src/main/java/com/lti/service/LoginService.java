package com.lti.service;

import com.lti.dto.LoginDto;
import com.lti.entity.Admin;
import com.lti.entity.Customer;
import com.lti.service.exception.LoginException;
import com.lti.status.LoginReturnStatus;

public interface LoginService {
	
	public LoginReturnStatus  loginAdmin(LoginDto loginDto) throws LoginException ;
	
	public LoginReturnStatus loginCustomer(LoginDto loginDto) throws LoginException ;

	

}
