package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AllotedDto;
import com.lti.dto.UpdateCustomerDto;
import com.lti.service.AllotedCardService;

import com.lti.service.exception.AllotedCardServiceException;
import com.lti.status.CustomerStatus;

@RestController
@CrossOrigin
public class AllotedCardController {

	@Autowired
	private AllotedCardService allotedCardService;

	@PostMapping("/allotedCardDetail")
	public CustomerStatus getAllotedCard(@RequestBody AllotedDto allotedDto) {
		CustomerStatus customerStatus = new CustomerStatus();
		try {
			String message = allotedCardService.addCard(allotedDto);
			customerStatus.setStatus(100);
			customerStatus.setMessage(message);
			return customerStatus;
		} catch (AllotedCardServiceException e) {
			customerStatus.setStatus(101);
			customerStatus.setMessage(e.getMessage());
			return customerStatus;

		}

	}
	
	
	@PostMapping("/active")
	public CustomerStatus getActivateCustomer(@RequestBody UpdateCustomerDto updateCustomerdto) {
		CustomerStatus customerStatus = new CustomerStatus();
		try {
			String message = allotedCardService.updateCustomer(updateCustomerdto);
			customerStatus.setStatus(100);
			customerStatus.setMessage(message);
			return customerStatus;
			
		}
		catch(Exception e) {
			customerStatus.setStatus(101);
			customerStatus.setMessage(e.getMessage());
			return customerStatus;
		}
	}
}