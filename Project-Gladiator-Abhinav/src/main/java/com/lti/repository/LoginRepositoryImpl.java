package com.lti.repository;

import java.util.Base64;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class LoginRepositoryImpl implements LoginRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int customerUserLogin(String username, String password) {
		
		String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
		
		return (Integer) entityManager
				.createQuery("select c.id from Customer as c where c.username= :un and c.password= :pw")
				.setParameter("un", username)
				.setParameter("pw", encodedPassword)
				.getSingleResult();
		// TODO Auto-generated method stub
		
	}

	@Override
	public int adminUserLogin(String username, String password) {
		String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
		
		return (Integer) entityManager
				.createQuery("select a.id from Admin as a where a.username= :un and a.password= :pw")
				.setParameter("un", username)
				.setParameter("pw", encodedPassword)
				.getSingleResult();
	}

	@Override
	public boolean isCustomerAvalable(String username) {
		// TODO Auto-generated method stub
		return (Long) entityManager
		.createQuery("select count(c.id) from Customer as c where c.username= :un")
		.setParameter("un", username)
		.getSingleResult()==1?true: false;
		
		
	}

	@Override
	public boolean isAdminAvalable(String username) {
		return (Long) entityManager
				.createQuery("select count(a.id) from Admin as a where a.username= :un")
				.setParameter("un", username)
				.getSingleResult()==1?true: false;
				
	}

	@Override
	public boolean isCustomerPasswordCorrect(String password, String username) {
		// TODO Auto-generated method stub
		String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
		
		return (Integer) entityManager
				.createQuery("select count(c.id) from Customer as c where c.username = :un and c.password= :pw")
				.setParameter("un", username)
				.setParameter("pw", encodedPassword)
				.getSingleResult()==1?true:false;
	}

	@Override
	public boolean isAdminPasswordCorrect(String password, String username) {
		String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
		
		return (Integer) entityManager
				.createQuery("select count(a.id) from Admin as a where a.username = :un and a.password= :pw")
				.setParameter("un", username)
				.setParameter("pw", encodedPassword)
				.getSingleResult()==1?true:false;
	}

}
