package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "product_detail")
@NamedQuery(name = "fetch-all-product" , query = "select p from Product as p")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@SequenceGenerator(sequenceName = "product_seq", allocationSize = 1, name = "product_seq")
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
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<OrderDetail> OrderDetail;

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
