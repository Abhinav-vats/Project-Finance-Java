package com.lti.repository;

import java.util.List;

import com.lti.entity.AllotedCard;
import com.lti.entity.Customer;

public interface AllotedCardRepository {
	
	
	Customer findById(int id);
	


	void updateCustomer(Customer c);
	
	

}
