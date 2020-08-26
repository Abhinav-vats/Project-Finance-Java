package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Customer;
import com.lti.entity.PaymentSchedule;
import com.lti.entity.Product;

@Repository
public class PaymentScheduleRepositoryImpl implements PaymentScheduleRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public List<PaymentSchedule> getPaymentList() {
		return entityManager
				.createQuery("select ps from PaymentSchedule as ps")
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
	public long countPayment() {
		return (Long) entityManager
				.createQuery("select count(ps.id) from PaymentSchedule as ps")
				.getSingleResult();
	}

}
