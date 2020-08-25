package com.lti.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lti.entity.Product;
import com.lti.service.ProductService;
import com.lti.service.exception.ProductServiceException;
import com.lti.status.ProductStatus;

@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(path = "/product", produces = "application/json")
	public ProductStatus indexDisplay() throws ProductServiceException {
		try {
			List<Product> productList = productService.displayProduct();
			ProductStatus stat = new ProductStatus();
			stat.setStatus(100);
			stat.setMessage("Page Loaded Successfully");
			stat.setProductList(productList);
			return stat;
		}
		catch(ProductServiceException e) {
			ProductStatus stat = new ProductStatus();
			stat.setStatus(101);
			stat.setMessage(e.getMessage());
			return stat;
		}
		
		
		
	}
	

}
