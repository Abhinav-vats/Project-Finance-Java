package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Customer;
import com.lti.repository.CustomerRepository;
import com.lti.service.exception.CustomerServiceException;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	public void register(Customer customer) throws  CustomerServiceException{
		if(!customerRepository.isCustomerAvailable(customer.getEmail())) {
			customerRepository.addCustomer(customer);
		}
		else 
			throw new CustomerServiceException("Customer Already Registered");
		
	}


	@Override
	public String checkUsernameAvailability(String username) throws  CustomerServiceException {
		if(customerRepository.isUsernameAvailable(username)) {
			return "Username available";
		}
		else
			return "Username Not Available, please try new username"; 
	}


	

}
