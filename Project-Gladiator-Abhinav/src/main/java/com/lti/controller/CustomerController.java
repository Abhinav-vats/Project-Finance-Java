package com.lti.controller;

import java.sql.SQLException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.lti.dto.CustomerDto;
import com.lti.entity.Customer;
import com.lti.service.CustomerService;
import com.lti.service.exception.CustomerServiceException;
import com.lti.status.CustomerStatus;

@RestController
@CrossOrigin
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/register")
	public CustomerStatus register(@RequestBody CustomerDto customerDto) {
		try {
			Customer customer = new Customer();
			BeanUtils.copyProperties(customerDto, customer);
			customerService.register(customer);
			
			CustomerStatus status = new CustomerStatus();
			status.setStatus(100);
			status.setMessage("Registration Successfull");
			return status;
			
		}
		catch(CustomerServiceException e) {
			CustomerStatus status = new CustomerStatus();
			status.setStatus(101);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	@PostMapping(path= "/checkusername", consumes = "text/plain")
	public CustomerStatus checkUsernameAvailability(@RequestBody String username) {
		try {
			String message = customerService.checkUsernameAvailability(username);
			CustomerStatus status = new CustomerStatus();
			status.setStatus(100);
			status.setMessage(message);
			return status;
		}
		catch(CustomerServiceException e) {
			CustomerStatus status = new CustomerStatus();
			status.setStatus(102);
			status.setMessage(e.getMessage());
			return status;
		}
	}
}
