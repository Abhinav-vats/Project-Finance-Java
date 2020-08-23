package com.lti.repository;

import java.util.Base64;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerLoginImpl implements CustomerLogin {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int customerLogin(String username, String password) {
		
		String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
		
		return (Integer) entityManager
				.createQuery("select c.id from Customer as c where c.username= :un and c.password= :pw")
				.setParameter("un", username)
				.setParameter("pw", encodedPassword)
				.getSingleResult();
		// TODO Auto-generated method stub
		
	}

}
