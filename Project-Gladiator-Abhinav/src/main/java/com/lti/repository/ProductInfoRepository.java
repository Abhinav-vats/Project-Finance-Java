package com.lti.repository;

import com.lti.dto.PurchaseProductDto;
import com.lti.entity.AllotedCard;
import com.lti.entity.Customer;
import com.lti.entity.OrderDetail;
import com.lti.entity.PaymentSchedule;
import com.lti.entity.PlanType;
import com.lti.entity.Product;


public interface ProductInfoRepository {
	Product findById(int id);

	Customer fetchCustomer(int userId);

	Product fetchProductById(int productId);

	PlanType fetchPlanTypeByPlan(String plan);

	void addNewOrder(OrderDetail orderDetail);

	AllotedCard fetchAllotedCardByCustomer(Customer customer);

	void updateAllotedCard(AllotedCard allotedCard);

	void addNewPaymentSchedule(PaymentSchedule paymentSchedule);

	boolean isCustomerEligible(PurchaseProductDto purchaseProductDto);



}
