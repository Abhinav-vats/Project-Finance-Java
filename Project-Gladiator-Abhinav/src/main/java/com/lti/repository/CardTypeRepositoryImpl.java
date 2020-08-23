package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import com.lti.entity.CardType;

public class CardTypeRepositoryImpl implements CardTypeRepository {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Transactional
	public void save(CardType cardType) {
		entityManager.merge(cardType);

	}

	@Override
	public CardType findById(int cardType) {
		return entityManager.find(CardType.class, cardType);
	}

	@Override
	public List<CardType> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
