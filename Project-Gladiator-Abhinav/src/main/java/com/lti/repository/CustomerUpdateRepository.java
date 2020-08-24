package com.lti.repository;

import org.springframework.data.repository.CrudRepository;

import com.lti.entity.Customer;

public interface CustomerUpdateRepository extends CrudRepository<Customer, Integer> {

}
