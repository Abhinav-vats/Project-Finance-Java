package com.lti.service;

import com.lti.dto.PurchaseProductDto;
import com.lti.entity.Product;

public interface ProductInfoService {

	Product findById(int id);

	String placeOrder(PurchaseProductDto purchaseProductDto);

}