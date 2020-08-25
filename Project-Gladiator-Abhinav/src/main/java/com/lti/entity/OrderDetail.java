package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;




@Entity
@Table(name="order_detail")
public class OrderDetail {
	@Id
	@GeneratedValue
	
	@Column(name = "id")
	private int orderId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Column(name = "price_paid")
	private int pricePaid;
	
	@ManyToOne
	@JoinColumn(name = "plan_id")
	private PlanType planType;
	
	public PlanType getPlanType() {
		return planType;
	}

	public void setPlanType(PlanType planType) {
		this.planType = planType;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getPricePaid() {
		return pricePaid;
	}

	public void setPricePaid(int pricePaid) {
		this.pricePaid = pricePaid;
	}

	
	

	
	
	
	
	
	

}
