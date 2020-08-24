package com.lti.repository;


import java.util.ArrayList;
import java.util.List;

import java.util.Base64;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void addCustomer(Customer customer) {
		String password = customer.getPassword();
		String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
		customer.setPassword(encodedPassword);
		entityManager.merge(customer);

	}

	
	@Transactional
	public void delete(int id) {
		Customer customer = entityManager.find(Customer.class, id);
		entityManager.remove(customer);
	}
	
	@Override
	public boolean isCustomerAvailable(String email) {
		// TODO Auto-generated method stub
		return (Long) entityManager
				.createQuery("select count(c.id) from Customer as c where c.email= :em")
				.setParameter("em", email)
				.getSingleResult()==1?true:false;
	}

	@Override
	public boolean isPresent(int id) {
		
		return (Long) entityManager
				.createQuery("select count(c.id) from Customer as c where c.id= :i")
				.setParameter("i", id)
				.getSingleResult()==1?true:false;
	}
	

	@Transactional
	public List<Customer> getUserList() {
	return entityManager.createNamedQuery("fetch-all-customer").getResultList();
		
	}
	
	@Transactional
	public long countCustomer() {
		return (Long) entityManager
				.createQuery("select count(c.id) from Customer as c")
				.getSingleResult();
	}

	
    
	/*
	@Transactional
	public int deleteById(int id) {
		return (int) entityManager
				.createQuery("Delete from Customer as c where c.id=:id")
				.getSingleResult();
	}
*/

	
	public boolean isUsernameAvailable(String username) {
		
		return (Long) entityManager
				.createQuery("select count(c.id) from Customer as c where c.username = :un")
				.setParameter("un", username)
				.getSingleResult()==0?true:false;
		
	}


	

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	

}
