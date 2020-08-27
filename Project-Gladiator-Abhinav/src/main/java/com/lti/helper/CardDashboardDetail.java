package com.lti.helper;

import java.time.LocalDate;

public class CardDashboardDetail {

	private String cardNo;
	
	private String name;
	
	private LocalDate validTill;
	
	private String cardType;
	
	private int cvvNo;
	
	private String cardActivity;
	
	private double totalCredit;
	
	private double creditUsed;
	
	private double creditRemaining;
	
	

	public String getCardNo() {
		return cardNo;
	}

	public String getName() {
		return name;
	}

	public LocalDate getValidTill() {
		return validTill;
	}

	public String getCardType() {
		return cardType;
	}

	public int getCvvNo() {
		return cvvNo;
	}

	public String getCardActivity() {
		return cardActivity;
	}

	public double getTotalCredit() {
		return totalCredit;
	}

	public double getCreditUsed() {
		return creditUsed;
	}

	public double getCreditRemaining() {
		return creditRemaining;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValidTill(LocalDate validTill) {
		this.validTill = validTill;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public void setCvvNo(int cvvNo) {
		this.cvvNo = cvvNo;
	}

	public void setCardActivity(String cardActivity) {
		this.cardActivity = cardActivity;
	}

	public void setTotalCredit(double totalCredit) {
		this.totalCredit = totalCredit;
	}

	public void setCreditUsed(double creditUsed) {
		this.creditUsed = creditUsed;
	}

	public void setCreditRemaining(double creditRemaining) {
		this.creditRemaining = creditRemaining;
	}

}
