package com.lti.entity;

 

import java.time.LocalDate;

 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

 

@Entity
@Table(name = "alloted_card_detail")
@NamedNativeQuery(name = "fetch-all", query = "select a from AllotedCard as a")
public class AllotedCard {

 

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int allocatedId;

<<<<<<< HEAD
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Customer customer;
	
	@Column(name = "card_cvv_no")
	private int cardCvvNo;
	
	@Column(name = "card_no")
	private String cardNo;
	
	@Column(name = "valid_till")
	private LocalDate validity;
	
	@Column(name ="card_credit_used")
	private double cardCreditUsed;
	
	@Column(name ="card_credit_remaining")
	private double cardCreditRemaining;
	
	
	@Column(name ="card_activation_status")
	private String cardActivationStatus;
=======
 
>>>>>>> branch 'master' of https://github.com/Abhinav-vats/Project-Finance-Java.git

    @ManyToOne
    @JoinColumn(name = "card_id")
    private CardType cardType;

 

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Customer customer;

 

    @Column(name = "card_cvv_no")
    private int cardCvvNo;

 

    @Column(name = "card_no")
    private String cardNo;

 

    @Column(name = "valid_till")
    private LocalDate validity;

 

    @Column(name = "card_credit_used")
    private double cardCreditUsed;

 

    @Column(name = "card_credit_remaining")
    private double cardCreditRemaining;

 

    @Column(name = "card_activation_status")
    private String cardActivationStatus;

 

    public int getAllocatedId() {
        return allocatedId;
    }

 

    public CardType getCardType() {
        return cardType;
    }

 

    public Customer getCustomer() {
        return customer;
    }

 

    public int getCardCvvNo() {
        return cardCvvNo;
    }

 

    public String getCardNo() {
        return cardNo;
    }

 

    public LocalDate getValidity() {
        return validity;
    }

 

    public double getCardCreditUsed() {
        return cardCreditUsed;
    }

 

    public double getCardCreditRemaining() {
        return cardCreditRemaining;
    }

 

    public String getCardActivationStatus() {
        return cardActivationStatus;
    }

<<<<<<< HEAD
	public String getCardActivationStatus() {
		return cardActivationStatus;
	}
=======
 
>>>>>>> branch 'master' of https://github.com/Abhinav-vats/Project-Finance-Java.git

    public void setAllocatedId(int allocatedId) {
        this.allocatedId = allocatedId;
    }

<<<<<<< HEAD
	public void setCardActivationStatus(String cardActivationStatus) {
		this.cardActivationStatus = cardActivationStatus;
	}
=======
 
>>>>>>> branch 'master' of https://github.com/Abhinav-vats/Project-Finance-Java.git

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

 

<<<<<<< HEAD


}
=======
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

 

    public void setCardCvvNo(int cardCvvNo) {
        this.cardCvvNo = cardCvvNo;
    }

 

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

 

    public void setValidity(LocalDate validity) {
        this.validity = validity;
    }

 

    public void setCardCreditUsed(double cardCreditUsed) {
        this.cardCreditUsed = cardCreditUsed;
    }

 

    public void setCardCreditRemaining(double cardCreditRemaining) {
        this.cardCreditRemaining = cardCreditRemaining;
    }

 

    public void setCardActivationStatus(String cardActivationStatus) {
        this.cardActivationStatus = cardActivationStatus;
    }
    
    

 

}
>>>>>>> branch 'master' of https://github.com/Abhinav-vats/Project-Finance-Java.git
