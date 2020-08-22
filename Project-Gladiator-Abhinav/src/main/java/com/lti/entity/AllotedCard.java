package com.lti.entity;

import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
@Entity
@Table(name= "alloted_card_detail")
@NamedNativeQuery(name = "fetch-all", query = "select a from AllotedCard as a")
public class AllotedCard {
	@Id
	@GeneratedValue
	
	@Column(name = "id" )
	private int allocatedCardId;
	
	@ManyToOne
	@JoinColumn(name = "card_id")
	private CardType cardType;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Customer customer;
	
	@Column(name = "card_cvv_no")
	private int cardCvvNo;
	
	@Column(name = "card_no")
	private int cardNo;
	
	@Column(name = "valid_till")
	private LocalDate validity;
	
	@Column(name ="card_credit_used")
	private double cardCreditUsed;
	
	@Column(name ="card_credit_remaining")
	private double cardCreditRemaining;
	
	
	
	@Column(name ="card_activation_status")
	private boolean cardActivationStatus;



	public int getAllocatedCardId() {
		return allocatedCardId;
	}



	public void setAllocatedCardId(int allocatedCardId) {
		this.allocatedCardId = allocatedCardId;
	}



	public CardType getCardType() {
		return cardType;
	}



	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
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



	public boolean isCardActivationStatus() {
		return cardActivationStatus;
	}



	public void setCardActivationStatus(boolean cardActivationStatus) {
		this.cardActivationStatus = cardActivationStatus;
	}
	
	


	
}