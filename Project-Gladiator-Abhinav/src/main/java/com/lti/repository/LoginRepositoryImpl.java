package com.lti.repository;

import java.util.Base64;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Admin;
import com.lti.entity.Customer;

@Repository
public class LoginRepositoryImpl implements LoginRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Customer customerUserLogin(String username, String password) {
		
		String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
		
		return (Customer) entityManager
				.createQuery("select c from Customer as c where c.username= :un and c.password= :pw")
				.setParameter("un", username)
				.setParameter("pw", encodedPassword)
				.getSingleResult();
	
		
	}

	@Override
	public Admin adminUserLogin(String username, String password) {
		String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
		
		return (Admin) entityManager
				.createQuery("select a from Admin as a where a.username= :un and a.password= :pw")
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
		
		return (Long) entityManager
				.createQuery("select count(c.id) from Customer as c where c.username = :un and c.password= :pw")
				.setParameter("un", username)
				.setParameter("pw", encodedPassword)
				.getSingleResult()==1?true:false;
	}

	@Override
	public boolean isAdminPasswordCorrect(String password, String username) {
		String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
		
		return (Long) entityManager
				.createQuery("select count(a.id) from Admin as a where a.username = :un and a.password= :pw")
				.setParameter("un", username)
				.setParameter("pw", encodedPassword)
				.getSingleResult()==1?true:false;
	}

	@Override
	public boolean customerActiveStatus(int id) {
		String isActive = (String) entityManager
				.createQuery("select c.isActive from Customer as c where c.id= :id")
				.setParameter("id", id)
				.getSingleResult();
		
		return  isActive.equals("true");
	}

	@Override
	public boolean hasCustomerUploadedDocument(int id) {
		
		return (Long) entityManager
				.createQuery("select count(d.id) from Document as d where d.customer.id = :id")
				.setParameter("id", id)
				.getSingleResult()==1?true:false;
		
		
		
	}

}
