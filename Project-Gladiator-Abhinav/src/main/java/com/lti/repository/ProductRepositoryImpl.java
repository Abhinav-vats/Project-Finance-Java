package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return entityManager
				.createNamedQuery("fetch-all-product")
				.getResultList();
	}

	@Transactional
	public long countProduct() {
		return (Long) entityManager
				.createQuery("select count(p.id) from Product as p")
				.getSingleResult();
	}

}
