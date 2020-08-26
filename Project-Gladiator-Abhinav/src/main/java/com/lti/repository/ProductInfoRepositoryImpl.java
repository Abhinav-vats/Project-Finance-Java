package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.PurchaseProductDto;
import com.lti.entity.AllotedCard;
import com.lti.entity.Customer;
import com.lti.entity.OrderDetail;
import com.lti.entity.PaymentSchedule;
import com.lti.entity.PlanType;
import com.lti.entity.Product;

@Repository
public class ProductInfoRepositoryImpl implements ProductInfoRepository{

	@PersistenceContext
	private EntityManager entityManager;

	public Product findById(int id) {
		return entityManager.find(Product.class, id);
	}

	@Override
	public Customer fetchCustomer(int userId) {
		return entityManager.find(Customer.class, userId);
	}

	@Override
	public Product fetchProductById(int productId) {
	
		return entityManager.find(Product.class, productId);
	}

	@Override
	public PlanType fetchPlanTypeByPlan(String plan) {
		
		return (PlanType) entityManager
				.createQuery("select p from PlanType as p where p.name= :pn")
				.setParameter("pn", plan)
				.getSingleResult();
	}

	@Transactional
	@Override
	public void addNewOrder(OrderDetail orderDetail) {
		 entityManager.merge(orderDetail);
		
	}

	@Override
	public AllotedCard fetchAllotedCardByCustomer(Customer customer) {
		return (AllotedCard) entityManager
				.createQuery("select a from AllotedCard as a where a.customer.id= :ac")
				.setParameter("ac",customer.getId())
				.getSingleResult();
	}

	@Transactional
	@Override
	public void updateAllotedCard(AllotedCard allotedCard) {
		
		 entityManager.merge(allotedCard);
	}

	@Transactional
	@Override
	public void addNewPaymentSchedule(PaymentSchedule paymentSchedule) {
		 entityManager.merge(paymentSchedule);
		
	}

	@Override
	public boolean isCustomerEligible(PurchaseProductDto purchaseProductDto) {
		double price = (Double) entityManager.createQuery("select p.costPerUnit from Product as p where p.id=:pid")
				.setParameter("pid", purchaseProductDto.getProductId())
				.getSingleResult();
		double credit =(Double) entityManager.createQuery("select a.cardCreditRemaining from AllotedCard as a where a.customer.id= :aid")
				.setParameter("aid",purchaseProductDto.getUserId())
				.getSingleResult();
		if(credit >= price) {
			return true;
		}
		else
			return false;
	}

	
}
