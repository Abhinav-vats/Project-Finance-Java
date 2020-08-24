package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.NamedNativeQuery;



@Entity
@Table(name="order_detail")
@NamedNativeQuery(name="fetch-all-order", query="select o from OrderDetail as o" )
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
	
	@Column(name = "plan_id")
	private int planId;

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

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}
	
	
	
	
	
	

}
