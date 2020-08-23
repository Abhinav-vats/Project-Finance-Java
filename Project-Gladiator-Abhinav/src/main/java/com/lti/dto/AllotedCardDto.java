package com.lti.dto;

import java.time.LocalDate;

public class AllotedCardDto {
	private int allocatedCardId;
	private int cardId;
	private int cardCvvNo;
	private int cardNo;
	private LocalDate validity;
	private double cardCreditUsed;
	private double cardCreditRemaining;
	private int userId;
	private boolean cardActivationStatus;

	public int getAllocatedCardId() {
		return allocatedCardId;
	}

	public void setAllocatedCardId(int allocatedCardId) {
		this.allocatedCardId = allocatedCardId;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public int getCardCvvNo() {
		return cardCvvNo;
	}

	public void setCardCvvNo(int cardCvvNo) {
		this.cardCvvNo = cardCvvNo;
	}

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public LocalDate getValidity() {
		return validity;
	}

	public void setValidity(LocalDate validity) {
		this.validity = validity;
	}

	public double getCardCreditUsed() {
		return cardCreditUsed;
	}

	public void setCardCreditUsed(double cardCreditUsed) {
		this.cardCreditUsed = cardCreditUsed;
	}

	public double getCardCreditRemaining() {
		return cardCreditRemaining;
	}

	public void setCardCreditRemaining(double cardCreditRemaining) {
		this.cardCreditRemaining = cardCreditRemaining;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isCardActivationStatus() {
		return cardActivationStatus;
	}

	public void setCardActivationStatus(boolean cardActivationStatus) {
		this.cardActivationStatus = cardActivationStatus;
	}

}
