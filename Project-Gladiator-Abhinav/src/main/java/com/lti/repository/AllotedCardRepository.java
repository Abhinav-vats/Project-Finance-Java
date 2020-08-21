package com.lti.repository;

import java.util.List;

import com.lti.entity.AllotedCard;

public interface AllotedCardRepository {
	void save(AllotedCard allotedCard);
	
	AllotedCard findById(int allocatedCardId);
	
	List<AllotedCard> findAll();
	
	

}
