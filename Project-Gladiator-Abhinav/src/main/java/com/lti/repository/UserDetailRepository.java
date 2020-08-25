package com.lti.repository;

import com.lti.entity.Customer;

public interface UserDetailRepository {

	Customer findById(int id);

}