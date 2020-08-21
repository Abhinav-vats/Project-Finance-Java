package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.lti.entity.AllotedCard;


public class AllotedCardRepositoryImpl implements AllotedCardRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Transactional
	public void save(AllotedCard allotedCard) {
		entityManager.merge(allotedCard);

	}

	@Override
	public AllotedCard findById(int allocatedCardId) {
		return entityManager.find(AllotedCard .class, allocatedCardId);
	}

	@Override
	public List<AllotedCard> findAll() {
		return entityManager.createNamedQuery("fetch-all").getResultList();
	}

}
