package com.lti.repository;

import java.util.List;

import com.lti.entity.Product;

public interface ProductRepository {
	
	List<Product> getProductList();
	
	long countProduct();

}
