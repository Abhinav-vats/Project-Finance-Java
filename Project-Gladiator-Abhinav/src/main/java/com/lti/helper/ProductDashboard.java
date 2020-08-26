package com.lti.helper;

public class ProductDashboard {
	
	private String productName;
	
	private double amount;
	
	private double paid;
	
	private int orderId;
	
	private int paymentId;
	
	
	
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getProductName() {
		return productName;
	}
	public double getAmount() {
		return amount;
	}
	public double getPaid() {
		return paid;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public void setPaid(double paid) {
		this.paid = paid;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	
	

}
