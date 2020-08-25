package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.CustomerAdminDto;
import com.lti.dto.CustomerDto;
import com.lti.dto.CustomerUpdateDto;
import com.lti.entity.Customer;
import com.lti.service.CustomerService;
import com.lti.service.exception.CustomerServiceException;

import com.lti.status.CustomerStatus;
import com.lti.status.UserStatus;
import com.lti.status.UsernameStatus;

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

		} catch (CustomerServiceException e) {
			CustomerStatus status = new CustomerStatus();
			status.setStatus(101);
			status.setMessage(e.getMessage());
			return status;
		}
	}

	@PostMapping(path = "/checkusername", consumes = "text/plain")
	public UsernameStatus checkUsernameAvailability(@RequestBody String username) {
		try {
			return customerService.checkUsernameAvailability(username);
		} catch (CustomerServiceException e) {
			UsernameStatus status = new UsernameStatus();
			status.setStatus(102);
			status.setMessage(e.getMessage());
			return status;
		}

	}

	@RequestMapping(path = "/user", produces = "application/json")
	public UserStatus indexDisplay() throws CustomerServiceException {
		try {
			List<Customer> userList = customerService.displayCustomer();
			List<CustomerAdminDto> customerAdminDtos = new ArrayList();

			for (Customer c : userList) {
				CustomerAdminDto customerAdminDto = new CustomerAdminDto();
				customerAdminDto.setId(c.getId());
				customerAdminDto.setFirstName(c.getFirstName());
				customerAdminDto.setMiddleName(c.getMiddleName());
				customerAdminDto.setLastName(c.getLastName());
				customerAdminDto.setUsername(c.getUsername());
				customerAdminDto.setIsActive(c.getIsActive());
				customerAdminDtos.add(customerAdminDto);

			}
			UserStatus stat = new UserStatus();
			stat.setStatus(100);
			stat.setMessage("User Page Successfully");
			stat.setUserList(customerAdminDtos);
			return stat;
		} catch (CustomerServiceException e) {
			UserStatus stat = new UserStatus();
			stat.setStatus(101);
			stat.setMessage(e.getMessage());
			return stat;

		}

	}

	@PostMapping("/delete")
	public CustomerStatus delete(@RequestBody Customer customer) {
		try {
			// int customerId=Integer.parseInt(id);
			customerService.delete(customer.getId());

			CustomerStatus status = new CustomerStatus();
			status.setStatus(100);
			status.setMessage("Deleted");
			return status;

		} catch (CustomerServiceException e) {
			CustomerStatus status = new CustomerStatus();
			status.setStatus(101);
			status.setMessage(e.getMessage());
			return status;
		}
	}

	@PostMapping("/update")
//@RequestMapping(path="/update",produces = "application/json")
	public CustomerStatus updateCustomer(@RequestBody CustomerUpdateDto customerUpdateDto) {
//public UserStatus updateCustomer(@RequestBody CustomerUpdateDto customerUpdateDto) {
		try {
			Customer customer = new Customer();

			BeanUtils.copyProperties(customerUpdateDto, customer);
			// List<Customer> userList = customerService.displayCustomer();
			customerService.update(customer);

			CustomerStatus status = new CustomerStatus();
			status.setStatus(200);

			// status.setUserList(userList);
			status.setMessage("Updated Successfull!");
			return status;

		} catch (CustomerServiceException e) {
			CustomerStatus status = new CustomerStatus();
			status.setMessage(e.getMessage());
			return status;
		}

	}
}
