package com.lti.service;

import com.lti.entity.Customer;
import com.lti.service.exception.CustomerServiceException;
import com.lti.status.UsernameStatus;

public interface CustomerService {
	
	void register(Customer customer) throws CustomerServiceException;
	
	UsernameStatus checkUsernameAvailability(String username) throws  CustomerServiceException;
	
	

}
