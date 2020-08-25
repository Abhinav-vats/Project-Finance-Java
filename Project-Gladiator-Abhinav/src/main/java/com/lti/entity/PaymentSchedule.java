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
@Table(name="payment_schedule")
@NamedQuery(name = "fetch-all-payments" , query = "select ps from PaymentSchedule as ps")

public class PaymentSchedule {
	
	@Id
	@GeneratedValue
	
	@Column(name="id")
	private int paymentId;
	
	@Column(name="month_count")
	private int monthCount;
	
	@Column(name="month_for")
	private String monthFor;
	
	@Column(name="payment_status")
	private String paymentStatus;
	
	@Column(name="card_share_amount")
	private int cardSharedAmount;
	
	@Column(name="late_fine_charged")
	private int lateFineCharged;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderDetail orderDetail;
	
	@ManyToOne
	@JoinColumn(name = "user_detail")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "plan_id")
	private PlanType planType;
	
	
	
	
	
	
	
	

}
