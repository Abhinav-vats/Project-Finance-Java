package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "document_upload")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_upload_seq")
	@SequenceGenerator(sequenceName = "document_upload_seq", allocationSize = 1, name = "document_upload_seq")
	@Column(name = "id")
	private int id;

	@Column(name = "aadhar_card")
	private String aadharCard;
	
	@Column(name = "pan_card")
	private String panCard;
	
	@Column(name = "blank_cheque")
	private String blankCheque;

	@OneToOne
	@JoinColumn(name = "user_id")
	private Customer customer;

	public int getId() {
		return id;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public String getPanCard() {
		return panCard;
	}

	public String getBlankCheque() {
		return blankCheque;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public void setBlankCheque(String blankCheque) {
		this.blankCheque = blankCheque;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
