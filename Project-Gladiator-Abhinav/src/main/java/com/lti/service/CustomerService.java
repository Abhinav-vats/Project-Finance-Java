package com.lti.service;

import java.util.List;

import com.lti.dto.CustomerDto;
import com.lti.dto.CustomerUpdateDTO;
import com.lti.entity.Customer;
import com.lti.service.exception.CustomerServiceException;

public interface CustomerService {
	
	void register(Customer customer) throws CustomerServiceException;

	public static List <Customer> getAllUser() throws CustomerServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id);
	
	public void updateCustomer(CustomerUpdateDTO customerUpdateDTO);
	
	
	
	
	

}
