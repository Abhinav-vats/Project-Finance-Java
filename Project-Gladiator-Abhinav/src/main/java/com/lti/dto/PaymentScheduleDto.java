package com.lti.dto;

import java.time.LocalDate;

public class PaymentScheduleDto {
	private int paymentId;
	

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	private int monthCount;
	
	private String monthFor;
	
	private String paymentStatus;
	
	private int orderid;
	
	private int userid;
	
	private LocalDate paymentDate;
	

	public int getMonthCount() {
		return monthCount;
	}

	public void setMonthCount(int monthCount) {
		this.monthCount = monthCount;
	}

	public String getMonthFor() {
		return monthFor;
	}

	public void setMonthFor(String monthFor) {
		this.monthFor = monthFor;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	

	

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	//private int lateFineCharged;
	
}
