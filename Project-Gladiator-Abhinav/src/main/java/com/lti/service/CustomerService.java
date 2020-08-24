package com.lti.service;

import java.util.List;

import com.lti.dto.CustomerDto;

import com.lti.dto.CustomerUpdateDto;
import com.lti.entity.Customer;
import com.lti.service.exception.CustomerServiceException;
import com.lti.status.UsernameStatus;

public interface CustomerService {
	
	void register(Customer customer) throws CustomerServiceException;

   List<Customer> displayCustomer() throws CustomerServiceException;
	
	
	void delete(int id) throws CustomerServiceException;
	
	public void updateCustomer(Customer customer);
	
	UsernameStatus checkUsernameAvailability(String username) throws  CustomerServiceException;


}
