package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "product_detail")
@NamedQuery(name = "fetch-all-product" , query = "select p from Product as p")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "model_name")
	private String modelName;

	@Column(name = "brand_name")
	private String brandName;

	@Column(name = "category")
	private String category;

	@Column(name = "detail")
	private String detail;

	@Column(name = "image_path")
	private String imagePath;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "cost_per_unit")
	private double costPerUnit;

	@Column(name = "profit_share")
	private double profitShare;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getModelName() {
		return modelName;
	}

	public String getBrandName() {
		return brandName;
	}

	public String getCategory() {
		return category;
	}

	public String getDetail() {
		return detail;
	}

	public String getImagePath() {
		return imagePath;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getCostPerUnit() {
		return costPerUnit;
	}

	public double getProfitShare() {
		return profitShare;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setCostPerUnit(double costPerUnit) {
		this.costPerUnit = costPerUnit;
	}

	public void setProfitShare(double profitShare) {
		this.profitShare = profitShare;
	}

}
