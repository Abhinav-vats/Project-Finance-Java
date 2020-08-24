package com.lti.status;

import java.util.List;

import com.lti.entity.*;

public class OrderDetailStatus {
	
	private int status;
	private String message;
	private List<OrderDetail> orderList;
	
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
	public List<OrderDetail> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<OrderDetail> orderList) {
		this.orderList = orderList;
	}
	

}
