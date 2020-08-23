package com.lti.status;

import java.util.List;

import com.lti.entity.Product;

public class ProductStatus {
	
	private int status;
	private String message;
	private List<Product> productList;
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
