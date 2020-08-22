package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Product;
import com.lti.repository.ProductRepository;
import com.lti.service.exception.ProductServiceException;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepo;

	@Override
	public List<Product> displayProduct() throws ProductServiceException {
		if(productRepo.countProduct()>0)
			return productRepo.getProductList();
		else 
			throw new ProductServiceException("No Product Available");
	}

}
