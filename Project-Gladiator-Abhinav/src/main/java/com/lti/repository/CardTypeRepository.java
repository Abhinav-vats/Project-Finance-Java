package com.lti.repository;

import java.util.List;


import com.lti.entity.CardType;

public interface CardTypeRepository{

	
	
void save(CardType cardType);
	
	CardType findById(int cardType);
	
	List<CardType> findAll();
}
