package com.lti.repository;

import java.util.List;

import com.lti.entity.Customer;

public interface CustomerRepository {
	
	void addCustomer(Customer customer);
	
	boolean isCustomerAvailable(String email);
	
	public boolean isUsernameAvailable(String username);
	void delete(int id);

	long countCustomer();

	
	boolean isPresent(int id);

	List<Customer> getUserList();

	

}
