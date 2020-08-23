package com.lti.repository;

import com.lti.entity.Admin;

public interface AdminRepository {
	
	
	void addAdmin(Admin admin);
	
	Admin diplayAdminById(int id , String password);

}
