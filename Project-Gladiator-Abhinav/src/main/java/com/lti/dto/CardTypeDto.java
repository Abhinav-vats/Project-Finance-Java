package com.lti.dto;



public class CardTypeDto {

	private int id;
	
	private String type;

	private double maximumLimit;

	private double joiningFee;

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
