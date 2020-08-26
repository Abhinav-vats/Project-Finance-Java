package com.lti.status;

import java.util.List;

import com.lti.dto.PaymentScheduleDto;

public class PaymentScheduleStatus {
	private int status;
	private String message;
	private List<PaymentScheduleDto> paymentScheduleList;
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
	public List<PaymentScheduleDto> getPaymentScheduleList() {
		return paymentScheduleList;
	}
	public void setPaymentScheduleList(List<PaymentScheduleDto> paymentScheduleList) {
		this.paymentScheduleList = paymentScheduleList;
	}
	
}
