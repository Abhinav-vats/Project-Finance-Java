package com.lti.dto;

public class ProductInfoDto {

	private String name;
	
	private String detail;
	
	private double costPerUnit;
	
	private  String imagePath;
	
	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	private int duration;
	
	private double emiStarting;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public double getCostPerUnit() {
		return costPerUnit;
	}

	public void setCostPerUnit(double costPerUnit) {
		this.costPerUnit = costPerUnit;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getEmiStarting() {
		return emiStarting;
	}

	public void setEmiStarting(double emiStarting) {
		this.emiStarting = emiStarting;
	}

	
	
	
	
}
	
	