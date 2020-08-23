package com.lti.repository;

import java.util.List;

import com.lti.entity.Customer;

public interface CustomerRepository {
	
	void addCustomer(Customer customer);
	
	boolean isCustomerAvailable(String email);
	
	public boolean isUsernameAvailable(String username);
	
	

	List<Customer> getAllUser();
	
	long countCustomer();

	int deleteById(int id);



	boolean isPresent(int id);

	

}
