package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Customer;
import com.lti.repository.AllotedCardRepository;

@Service
public class AllotedCardService {
	
	@Autowired
	private AllotedCardRepository allotedCardRepository;

	public String activateCustomerById(int id) {
		Customer c = allotedCardRepository.findById(id);
		
		//added
		//customer class mai isActive attribute ko public karna hoga, the ye error jayega 
		c.isActive = "true";
		allotedCardRepository.updateCustomer(c);
		return c.getCardType();
	}
}