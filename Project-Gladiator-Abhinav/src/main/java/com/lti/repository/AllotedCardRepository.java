package com.lti.repository;

import java.util.List;

import com.lti.entity.AllotedCard;
import com.lti.entity.Customer;
import com.lti.entity.Product;

public interface AllotedCardRepository {
	public List<AllotedCard> alloctedCard();

	Customer findById(int id);
	
	void updateCustomer(Customer c);
	
	

}
