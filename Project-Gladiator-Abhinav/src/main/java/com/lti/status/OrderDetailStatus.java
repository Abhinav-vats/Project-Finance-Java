package com.lti.status;

import java.util.List;

import com.lti.dto.OrderDetailDto;
import com.lti.entity.*;

public class OrderDetailStatus {
	
	private int status;
	private String message;
	private List<OrderDetailDto> orderList;
	
	public List<OrderDetailDto> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<OrderDetailDto> orderList) {
		this.orderList = orderList;
	}
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
}
	


