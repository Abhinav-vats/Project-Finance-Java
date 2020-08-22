package com.lti.service;

import com.lti.entity.Customer;
import com.lti.service.exception.CustomerServiceException;

public interface CustomerService {
	
	void register(Customer customer) throws CustomerServiceException;
	
	

}
