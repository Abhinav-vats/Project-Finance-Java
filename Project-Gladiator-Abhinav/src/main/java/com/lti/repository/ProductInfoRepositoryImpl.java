package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Product;

@Repository
public class ProductInfoRepositoryImpl implements ProductInfoRepository{

	@PersistenceContext
	private EntityManager entityManager;

	public Product findById(int id) {
		return entityManager.find(Product.class, id);
	}
}
