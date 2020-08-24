package com.lti.repository;

import java.util.List;

import com.lti.entity.AllotedCard;
import com.lti.entity.CardType;
import com.lti.entity.Customer;
import com.lti.entity.Product;

public interface AllotedCardRepository {
	

	
	

	
	 Customer findCustomerById(int id);

	public boolean isCardPresent(String cardNo);

	CardType fetchCardType(String cardType);

	void addAllotedCard(AllotedCard allotedCard);
	void updateCustomer(Customer customer);
}
