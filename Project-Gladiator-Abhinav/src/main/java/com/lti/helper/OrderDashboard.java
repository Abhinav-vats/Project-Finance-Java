package com.lti.helper;

public class OrderDashboard {

	private int orderId;
	private String productName;
	private double productPrice;
	private double amountPaid;
	private String category;
	
	
	public double getProductPrice() {
		return productPrice;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public int getOrderId() {
		return orderId;
	}
	public String getProductName() {
		return productName;
	}
	
	public String getCategory() {
		return category;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	
}
