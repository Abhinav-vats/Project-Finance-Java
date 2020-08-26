package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Customer;
import com.lti.entity.OrderDetail;
import com.lti.entity.Product;

@Repository
public class OrderDetailRepositoryImpl implements OrderDetailRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Transactional
	public List<OrderDetail> getOrderList() {
		return entityManager
				.createQuery("select o from OrderDetail as o")
				.getResultList();
	}

	@Override
	public Customer findById(int id) {
		
		return entityManager.find(Customer.class, id);
	}
	
	@Override
	public Product findByProductId(int id) {
		
		return entityManager.find(Product.class, id);
	}
	
	@Transactional
	public long countOrder() {
		return (Long) entityManager
				.createQuery("select count(o.id) from OrderDetail as o")
				.getSingleResult();
		
		
	}
	
	

}
