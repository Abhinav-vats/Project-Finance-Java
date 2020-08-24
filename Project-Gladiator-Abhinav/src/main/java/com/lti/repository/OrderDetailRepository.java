package com.lti.repository;

import com.lti.entity.*;

import java.util.List;

public interface OrderDetailRepository {
	
	List<OrderDetail> getOrderList();
	
	Customer findById(int id);
	
	long countOrder();
	
	

}
