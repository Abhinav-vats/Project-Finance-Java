package com.lti.repository;

public interface LoginRepository {
	
	int customerUserLogin(String username, String password);
	
	int adminUserLogin(String username, String password);
	
	boolean isCustomerAvalable(String username);
	
	boolean isAdminAvalable(String username);

	boolean isCustomerPasswordCorrect(String password, String username);

	boolean isAdminPasswordCorrect(String password, String username);
	
	

}
