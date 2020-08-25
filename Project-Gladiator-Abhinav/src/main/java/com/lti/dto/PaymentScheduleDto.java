package com.lti.dto;


public class PaymentScheduleDto {
	
	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

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

	public int getCardSharedAmount() {
		return cardSharedAmount;
	}

	public void setCardSharedAmount(int cardSharedAmount) {
		this.cardSharedAmount = cardSharedAmount;
	}

	public int getLateFineCharged() {
		return lateFineCharged;
	}

	public void setLateFineCharged(int lateFineCharged) {
		this.lateFineCharged = lateFineCharged;
	}

	private int paymentId;
	
	private int monthCount;
	
	private String monthFor;
	
	private String paymentStatus;
	
	private int cardSharedAmount;
	
	private int lateFineCharged;
	
	
	

}
