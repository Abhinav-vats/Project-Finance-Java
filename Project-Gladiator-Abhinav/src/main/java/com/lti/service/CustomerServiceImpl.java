package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Customer;
import com.lti.repository.CustomerRepository;
import com.lti.service.exception.CustomerServiceException;
import com.lti.status.UsernameStatus;


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
	public UsernameStatus checkUsernameAvailability(String username) throws  CustomerServiceException {
		UsernameStatus usernameStatus = new UsernameStatus();
		if(customerRepository.isUsernameAvailable(username)) {
			
			usernameStatus.setStatus(100);
			usernameStatus.setMessage("Username available");
			return usernameStatus;
		}
		else {
			usernameStatus.setStatus(104);
			usernameStatus.setMessage("Username Not Available, please try new username");
			return usernameStatus;
		}
			
		
			
	}


	

}
