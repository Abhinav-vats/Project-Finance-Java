package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Product;
import com.lti.repository.ProductInfoRepository;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {
	@Autowired
	private ProductInfoRepository productInfoRepository;
	@Override
	public Product findById(int id){
		return productInfoRepository.findById(id);
		}
}
