package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Customer;

@Repository
public class UserDetailRepositoryImpl implements UserDetailRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Customer findById(int id) {
		return entityManager.find(Customer.class, id);
	}

	@Override
	public boolean isAadharAvailable(int id) {
		//Customer customer= entityManager.find(Customer.class, id);
		
		return (Long) entityManager
				.createQuery("select count(d.id) from Document as d where d.customer.id= :id and d.documentType= :adh")
				.setParameter("id", id)
				.setParameter("adh", "Aadhar Card")
				.getSingleResult()==1?true:false;
	}

	@Override
	public String aadharDocumentPath(int id) {
		//Customer customer= entityManager.find(Customer.class, id);
		return (String) entityManager
				.createQuery("select d.documentPath from Document as d where d.customer.id= :id and d.documentType= :adh")
				.setParameter("id", id)
				.setParameter("adh", "Aadhar Card")
				.getSingleResult();
	}

	@Override
	public boolean isPanCardAvailable(int id) {
		//Customer customer= entityManager.find(Customer.class, id);
		return (Long) entityManager
				.createQuery("select count(d.id) from Document as d where d.customer.id= :id and d.documentType= :adh")
				.setParameter("id", id)
				.setParameter("adh", "Pan Card")
				.getSingleResult()==1?true:false;
	}

	@Override
	public String panCardDocumentPath(int id) {
		//Customer customer= entityManager.find(Customer.class, id);
		
		return (String) entityManager
				.createQuery("select d.documentPath from Document as d where d.customer.id= :id and d.documentType= :adh")
				.setParameter("id", id)
				.setParameter("adh", "Pan Card")
				.getSingleResult();
	}

	@Override
	public boolean isBlankChequeAvailable(int id) {
		//Customer customer= entityManager.find(Customer.class, id);
		return (Long) entityManager
				.createQuery("select count(d.id) from Document as d where d.customer.id= :id and d.documentType= :adh")
				.setParameter("id", id)
				.setParameter("adh", "Blank Cheque")
				.getSingleResult()==1?true:false;
	}

	@Override
	public String blankChequeDocumentPath(int id) {
		//Customer customer= entityManager.find(Customer.class, id);
		return (String) entityManager
				.createQuery("select d.documentPath from Document as d where d.customer.id= :id and d.documentType= :adh")
				.setParameter("id", id)
				.setParameter("adh", "Blank Cheque")
				.getSingleResult();
	}
}
