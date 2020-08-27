package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Customer;
import com.lti.entity.Document;

@Repository
public class UploadRepositoryImpl implements UploadRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Customer fetchCustomerById(int userId) {
		
		return entityManager.find(Customer.class, userId);
	}

	@Transactional
	@Override
	public void addNewDocument(Document document) {
		entityManager.merge(document);
		
	}

	
	
	

	

}
