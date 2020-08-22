package com.lti.entity;

import java.time.LocalDate;

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
	private int allocatedId;
	
	@Column(name = "card_id" )
	private int allocatedCardId1;
	
	@Column( name = "user_id")
	private int user_id;
	
	
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

	@ManyToOne
	@JoinColumn(name = "card_id")
	private CardType cardType;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Customer customer;

	public int getAllocatedId() {
		return allocatedId;
	}

	public void setAllocatedId(int allocatedId) {
		this.allocatedId = allocatedId;
	}

	public int getAllocatedCardId1() {
		return allocatedCardId1;
	}

	public void setAllocatedCardId1(int allocatedCardId1) {
		this.allocatedCardId1 = allocatedCardId1;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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


	


	
}