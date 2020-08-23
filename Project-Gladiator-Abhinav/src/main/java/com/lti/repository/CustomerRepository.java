package com.lti.repository;

import com.lti.entity.Customer;

public interface CustomerRepository {
	
	void addCustomer(Customer customer);
	
	boolean isCustomerAvailable(String email);
	
	public boolean isUsernameAvailable(String username);
	
	

}
