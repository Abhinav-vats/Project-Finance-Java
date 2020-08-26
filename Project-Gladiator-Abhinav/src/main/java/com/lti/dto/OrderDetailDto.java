package com.lti.dto;


public class OrderDetailDto {
	
	private int orderId;
	private int user_id;
	private int product_id;
	private int pricePaid;
	private int plan_id;
	
	
	public int getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getPricePaid() {
		return pricePaid;
	}
	public void setPricePaid(int pricePaid) {
		this.pricePaid = pricePaid;
	}
	
	

}
