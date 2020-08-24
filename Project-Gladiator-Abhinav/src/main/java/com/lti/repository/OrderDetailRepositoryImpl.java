package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Customer;
import com.lti.entity.OrderDetail;

@Repository
public class OrderDetailRepositoryImpl implements OrderDetailRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Transactional
	public List<OrderDetail> getOrderList() {
		return entityManager
				.createNamedQuery("fetch-all-order")
				.getResultList();
	}

	@Override
	public Customer findById(int id) {
		
		return entityManager.find(Customer.class, id);
	}
	
	@Transactional
	public long countOrder() {
		return (Long) entityManager
				.createQuery("select count(o.id) from OrderDetail as o")
				.getSingleResult();
		
		
	}
	
	

}
