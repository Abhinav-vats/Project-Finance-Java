package com.lti.repository;

import java.util.List;

import com.lti.entity.AllotedCard;
import com.lti.entity.CardType;
import com.lti.entity.Customer;
import com.lti.entity.Product;

public interface AllotedCardRepository {
	public List<AllotedCard> alloctedCard();

	Customer findById(int id);
	
	CardType fetchCardType(int id);
	
	void updatealloted(AllotedCard allotedcard);
	 void updateCustomer(Customer customer);

}
