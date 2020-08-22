package com.lti.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.controller.CustomerController.CustomerStatus.CustomerStatusType;
import com.lti.dto.CustomerDto;
import com.lti.entity.Customer;
import com.lti.service.CustomerService;
import com.lti.service.exception.CustomerServiceException;

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
			status.setStatus(CustomerStatusType.SUCCESS);
			status.setMessage("Registration Successfull");
			return status;
			
		}
		catch(CustomerServiceException e) {
			CustomerStatus status = new CustomerStatus();
			status.setStatus(CustomerStatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
public static class CustomerStatus{
		
		private CustomerStatusType status;
		private String message;
		
		
		
		public CustomerStatusType getStatus() {
			return status;
		}



		public String getMessage() {
			return message;
		}



		public void setStatus(CustomerStatusType status) {
			this.status = status;
		}



		public void setMessage(String message) {
			this.message = message;
		}



		public static enum CustomerStatusType{
			SUCCESS, FAILURE;
		}
		
	}
	

}
