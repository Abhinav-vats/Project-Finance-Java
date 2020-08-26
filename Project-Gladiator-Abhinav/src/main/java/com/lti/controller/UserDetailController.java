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
			//int customerId=Integer.parseInt(id);
			Customer customer= userDetailService.findById(customerIdDto.getId());
			UserDetailDto userDetailDto = new UserDetailDto();
			BeanUtils.copyProperties(customer, userDetailDto);
			
			String aadhar = userDetailService.fetchAadhar(customerIdDto.getId());
			String panCard = userDetailService.fetchPanCard(customerIdDto.getId());
			String blankCheque = userDetailService.fetchBlankCheque(customerIdDto.getId());
			
			UserDetailStatus status = new UserDetailStatus();
			status.setStatus(110);
			status.setMessage("Fetched");
			status.setUserDetailDto(userDetailDto);
			status.setAadhar(aadhar);
			status.setPanCard(panCard);
			status.setBlankCheque(blankCheque);
			return status;
			
		}
		catch(CustomerServiceException e) {
			UserDetailStatus status = new UserDetailStatus();
			status.setStatus(101);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	
}
