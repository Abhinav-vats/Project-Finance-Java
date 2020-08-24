package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.AllotedCard;
import com.lti.entity.CardType;
import com.lti.entity.Customer;
import com.lti.entity.Product;

@Repository
public class AllotedCardRepositoryImpl implements AllotedCardRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	

	@Override
	public Customer findCustomerById(int id) {
		return entityManager.find(Customer.class, id);
	}



	@Override
	public boolean isCardPresent(String cardNo) {
	
		return (Long) entityManager
				.createQuery("select count(ac.id) from AllotedCard as ac where ac.cardNo = :cn")
				.setParameter("cn", cardNo)
				.getSingleResult()==1? true: false;
				
	}



	@Override
	public CardType fetchCardType(String cardType) {
		return (CardType) entityManager
				.createQuery("select ct from CardType as ct where ct.type = :c")
				.setParameter("c",cardType)
				.getSingleResult();
	}



	@Override
	public void addAllotedCard(AllotedCard allotedCard) {
		
		entityManager.merge(allotedCard);
	}
	
	

public void updateCustomer(Customer customer) {
		
		entityManager.merge(customer);
	}





}