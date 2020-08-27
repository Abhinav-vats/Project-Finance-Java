package com.lti.helper;

import java.time.LocalDate;

public class TransactionDashboard {
	
	private int orderId;
	
	private String productName;
	
	private LocalDate paymentDate;
	
	private double amount;
	
	public int getOrderId() {
		return orderId;
	}
	public String getProductName() {
		return productName;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}
