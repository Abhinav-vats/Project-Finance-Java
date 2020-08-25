package com.lti.entity;

import java.time.LocalDate;

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
	
	@Column(name="installment")
	private int installment;
	
	@Column(name= "payment_date")
	private LocalDate paymentDate;
		
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderDetail orderDetail;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "plan_id")
	private PlanType planType;
	
	

	public int getInstallment() {
		return installment;
	}


	public void setInstallment(int installment) {
		this.installment = installment;
	}


	public int getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}


	public int getMonthCount() {
		return monthCount;
	}


	public void setMonthCount(int monthCount) {
		this.monthCount = monthCount;
	}


	public String getMonthFor() {
		return monthFor;
	}


	public void setMonthFor(String monthFor) {
		this.monthFor = monthFor;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}




	public OrderDetail getOrderDetail() {
		return orderDetail;
	}


	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public PlanType getPlanType() {
		return planType;
	}


	public void setPlanType(PlanType planType) {
		this.planType = planType;
	}


	public LocalDate getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
	
	
	

}
