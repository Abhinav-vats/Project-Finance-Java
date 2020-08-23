package com.lti.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lti.controller.CustomerController.CustomerStatus.CustomerStatusType;
import com.lti.controller.ProductController.ProductStatus;
import com.lti.dto.CustomerDto;
import com.lti.entity.Customer;
import com.lti.entity.Product;
import com.lti.service.CustomerService;
import com.lti.service.exception.CustomerServiceException;
import com.lti.service.exception.ProductServiceException;

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



@RequestMapping(path = "/user", produces = "application/json")
public UserStatus indexDisplay() throws CustomerServiceException {
	try {
		List<Customer> userList = CustomerService.getAllUser();
		UserStatus stat = new UserStatus();
		stat.setStatus(100);
		stat.setMessage("User Page Successfully");
		stat.setUserList(userList);
		return stat;
	}
	catch(CustomerServiceException e) {
		UserStatus stat = new UserStatus();
		stat.setStatus(101);
		stat.setMessage(e.getMessage());
		return stat;
	}
	
	
	
	
	
}

public static class UserStatus{
	private int status;
	private String message;
	private List<Customer> userList;
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public List<Customer> getUserList() {
		return userList;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setUserList(List<Customer> userList) {
		this.userList = userList;
	}
	
	
}


@DeleteMapping("/user/{id}")  
private void deleteCustomer(@PathVariable("id") int id)   
{  
customerService.delete(id);  
}  



@PostMapping("/updated")
public CustomerStatus update(@RequestBody CustomerDto customerDto) {
	try {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDto, customer);
		customerService.register(customer);
		
		CustomerStatus status = new CustomerStatus();
		status.setStatus(CustomerStatusType.SUCCESS);
		status.setMessage("Updated Successfull");
		return status;
		
	}
	catch(CustomerServiceException e) {
		CustomerStatus status = new CustomerStatus();
		status.setStatus(CustomerStatusType.FAILURE);
		status.setMessage(e.getMessage());
		return status;
	}
}


}
