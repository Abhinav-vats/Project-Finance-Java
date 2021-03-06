package com.lti.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lti.service.OrderDetailService;

import java.util.ArrayList;
import java.util.List;
import com.lti.service.exception.OrderDetailServiceException;

import com.lti.status.OrderDetailStatus;
import com.lti.dto.OrderDetailDto;
import com.lti.entity.*;

@RestController
@CrossOrigin
public class OrderDetailController {
	
	@Autowired
	private OrderDetailService orderdetailService;
	
	@RequestMapping(path = "/order", produces = "application/json")
	public OrderDetailStatus indexDisplay() throws OrderDetailServiceException {
		try {
			List<OrderDetail> orderList = orderdetailService.displayOrder();
			OrderDetailStatus stat = new OrderDetailStatus();
			List<OrderDetailDto> o = new ArrayList();
			for(OrderDetail l: orderList ) {
				OrderDetailDto ol = new OrderDetailDto();
				ol.setOrderId(l.getOrderId());
				ol.setPlanid(l.getPlanType().getPlanId());
				ol.setProductid(l.getProduct().getId());
				ol.setUserid(l.getCustomer().getId());
				ol.setPricePaid(l.getPricePaid());
				o.add(ol);
				
			}
			stat.setStatus(106);
			stat.setMessage("Order Page Loaded Successfully");
			stat.setOrderList(o);
			return stat;
		}
		catch(OrderDetailServiceException e) {
		OrderDetailStatus stat = new OrderDetailStatus();
		stat.setStatus(107);
		stat.setMessage(e.getMessage());
		return stat;
	}

	}
	
}
