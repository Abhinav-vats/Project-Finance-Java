package com.lti.repository;

import org.springframework.data.repository.CrudRepository;

import com.lti.entity.Customer;

public interface CustomerUpdateRepositiry extends CrudRepository<Customer, Long> {

}
