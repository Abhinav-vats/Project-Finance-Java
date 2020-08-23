package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.AllotedCard;
import com.lti.entity.Customer;
import com.lti.entity.Product;

@Repository
public class AllotedCardRepositoryImpl implements AllotedCardRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Transactional
	public void updateCustomer(Customer customer) {
		entityManager.merge(customer);
	}
	@Transactional
	public List<AllotedCard> alloctedCard() {
		// TODO Auto-generated method stub
		return entityManager
				.createNamedQuery("fetch-all")
				.getResultList();
	}
	
	@Override
	public Customer findById(int id) {
		return entityManager.find(Customer.class, id);
	}



	


}