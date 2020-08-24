package com.lti.service;

import java.util.List;
import com.lti.repository.*;
import com.lti.service.exception.OrderDetailServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.OrderDetail;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailRepository orderRepo;
	
	@Override
	public List<OrderDetail> displayOrder() throws OrderDetailServiceException {
		if(orderRepo.countOrder()>0)
			return orderRepo.getOrderList();
		else 
			throw new OrderDetailServiceException("No Orders yet");
	}
		
	}


