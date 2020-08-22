package com.lti.service;

import java.util.List;

import com.lti.entity.Product;
import com.lti.service.exception.ProductServiceException;

public interface ProductService {
	
	List<Product> displayProduct() throws ProductServiceException;
	
}
