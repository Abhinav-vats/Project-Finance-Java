package com.lti.status;

import com.lti.dto.ProductInfoDto;

public class ProductInfoStatus {
	private int status;
	private String message;
	private ProductInfoDto productInfoDto;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ProductInfoDto getProductInfoDto() {
		return productInfoDto;
	}
	public void setProductInfoDto(ProductInfoDto productInfoDto) {
		this.productInfoDto = productInfoDto;
	}
	
}
