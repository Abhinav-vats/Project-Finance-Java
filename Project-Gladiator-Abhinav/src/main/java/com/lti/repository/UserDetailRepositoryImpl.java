package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Customer;

@Repository
public class UserDetailRepositoryImpl implements UserDetailRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Customer findById(int id) {
		return entityManager.find(Customer.class, id);
	}
}
