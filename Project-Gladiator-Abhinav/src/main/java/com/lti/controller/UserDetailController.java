package com.lti.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.CustomerIdDto;
import com.lti.dto.UserDetailDto;
import com.lti.entity.Customer;
import com.lti.service.UserDetailService;
import com.lti.service.exception.CustomerServiceException;
import com.lti.status.UserDetailStatus;

@RestController
@CrossOrigin
public class UserDetailController {

	@Autowired
	private UserDetailService userDetailService;
	
	
	@PostMapping("/fetch")
	public UserDetailStatus delete(@RequestBody CustomerIdDto customerIdDto) {
		try {
			return userDetailService.findById(customerIdDto.getId());			
		}
		catch(CustomerServiceException e) {
			UserDetailStatus status = new UserDetailStatus();
			status.setStatus(101);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	
}
