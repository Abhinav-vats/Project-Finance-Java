package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name= "card_type_detail")
public class CardType {
	
	
	@Id
	@GeneratedValue
	@Column(name = "id" )
	private int id;
	
	
	@Column(name = "CARD_TYPE" )
	private String type;
	
	@Column(name = "MAXIMUM_LIMIT" )
	private double maximumLimit;
	
	
	@Column(name = "JOINING_FEE")
	private double joiningFee;
	
	
	@OneToMany(mappedBy = "cardType", cascade = CascadeType.ALL)
	private List<AllotedCard> alloctedCard;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getMaximumLimit() {
		return maximumLimit;
	}
	public void setMaximumLimit(double maximumLimit) {
		this.maximumLimit = maximumLimit;
	}
	public double getJoiningFee() {
		return joiningFee;
	}
	public void setJoiningFee(double joiningFee) {
		this.joiningFee = joiningFee;
	}
	
	
	
	
	
	

}
