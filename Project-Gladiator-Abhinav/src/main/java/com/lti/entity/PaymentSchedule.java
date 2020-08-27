package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "payment_schedule")
@NamedQuery(name = "fetch-all-payments", query = "select ps from PaymentSchedule as ps")

public class PaymentSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
	@SequenceGenerator(sequenceName = "payment_seq", allocationSize = 1, name = "payment_seq")

	@Column(name = "id")
	private int paymentId;

	@Column(name = "month_count")
	private int monthCount;

	@Column(name = "month_for")
	private String monthFor;

	@Column(name = "payment_status")
	private String paymentStatus;

	@Column(name = "installment")
	private double installment;

	@Column(name = "payment_date")
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

	public int getPaymentId() {
		return paymentId;
	}

	public int getMonthCount() {
		return monthCount;
	}

	public String getMonthFor() {
		return monthFor;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public double getInstallment() {
		return installment;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public Customer getCustomer() {
		return customer;
	}

	public PlanType getPlanType() {
		return planType;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public void setMonthCount(int monthCount) {
		this.monthCount = monthCount;
	}

	public void setMonthFor(String monthFor) {
		this.monthFor = monthFor;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public void setInstallment(double installment) {
		this.installment = installment;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setPlanType(PlanType planType) {
		this.planType = planType;
	}

}
