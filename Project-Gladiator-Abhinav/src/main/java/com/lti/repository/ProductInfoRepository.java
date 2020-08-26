package com.lti.repository;

import com.lti.entity.Product;

public interface ProductInfoRepository {
	Product findById(int id);
}
