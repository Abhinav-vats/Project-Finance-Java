package com.lti.service;

import com.lti.entity.Customer;
import com.lti.status.UserDetailStatus;

public interface UserDetailService {

	UserDetailStatus findById(int id);

	
}