package com.lti.repository;

import com.lti.entity.Admin;
import com.lti.entity.Customer;

public interface LoginRepository {
	
	Customer customerUserLogin(String username, String password);
	
	Admin adminUserLogin(String username, String password);
	
	boolean isCustomerAvalable(String username);
	
	boolean isAdminAvalable(String username);

	boolean isCustomerPasswordCorrect(String password, String username);

	boolean isAdminPasswordCorrect(String password, String username);
	
	boolean customerActiveStatus(int id);
	
	boolean hasCustomerUploadedDocument(int id);
	
	

}
