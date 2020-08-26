package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Customer;
import com.lti.entity.PaymentSchedule;

@Repository
public class PaymentScheduleRepositoryImpl implements PaymentScheduleRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public List<PaymentSchedule> getPaymentList() {
		return entityManager
				.createNamedQuery("fetch-all-payments")
				.getResultList();
	}

	@Override
	public Customer findById(int id) {
		return entityManager.find(Customer.class, id);
	}
	
	@Transactional
	public long countPayment() {
		return (Long) entityManager
				.createQuery("select count(ps.id) from PaymentSchedule as ps")
				.getSingleResult();
	}

}
