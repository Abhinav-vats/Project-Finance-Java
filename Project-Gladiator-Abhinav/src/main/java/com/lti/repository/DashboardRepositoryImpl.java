package com.lti.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.AllotedCard;
import com.lti.entity.OrderDetail;
import com.lti.entity.PaymentSchedule;

@Repository
public class DashboardRepositoryImpl implements DashboardRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public AllotedCard fetchAllotedCardDetailByUserId(int i) {
		return (AllotedCard) entityManager.createQuery("select a from AllotedCard as a where a.customer.id= :id")
				.setParameter("id", i).getSingleResult();
	}

	@Override
	public List<PaymentSchedule> fetchListOfUnpaidOrderForCurrentMonthByCustomerId(int i) {
		return entityManager
				.createQuery("select p from PaymentSchedule as p where p.customer.id = :id and p.paymentStatus= :ps")
				.setParameter("id", i).setParameter("ps", "false").getResultList();
	}

	@Override
	public List<PaymentSchedule> fetchLastTransactionByCustomer(int i) {
		return entityManager
				.createQuery("select p from PaymentSchedule as p where p.customer.id = :id and p.paymentStatus= :ps")
				.setParameter("id", i).setParameter("ps", "true").getResultList();
	}

	@Override
	public boolean isAllotedCardPresent(int id) {
		// TODO Auto-generated method stub
		return (Long) entityManager
				.createQuery("select count(a.id) from AllotedCard as a where a.customer.id = :id")
				.setParameter("id", id)
				.getSingleResult()>0?true:false;
	}

	@Override
	public boolean isUnpaidOrderLeftForCustomerById(int id) {
		return (Long) entityManager
				.createQuery("select count(p.id) from PaymentSchedule as p where p.customer.id= :id")
				.setParameter("id", id)
				.getSingleResult()>0?true:false;
	}

	@Override
	public boolean isPaymentSchedulePresent(int id) {
		return (Long) entityManager
				.createQuery("select count(p.id) from PaymentSchedule as p where p.id= :id")
				.setParameter("id", id)
				.getSingleResult()==1?true:false;
	}

	@Transactional
	@Override
	public void updatePaymentScheduleToPaid(int id) {
		PaymentSchedule paymentSchedule = entityManager.find(PaymentSchedule.class, id);
		
		OrderDetail orderDetail = paymentSchedule.getOrderDetail();
		
		orderDetail.setPricePaid(orderDetail.getPricePaid()+paymentSchedule.getInstallment());
		
		int customerId = orderDetail.getCustomer().getId();
		
		AllotedCard allotedCard = (AllotedCard) entityManager
				.createQuery("select a from AllotedCard as a where a.customer.id= :id")
				.setParameter("id", customerId)
				.getSingleResult();
		
		allotedCard.setCardCreditRemaining(allotedCard.getCardCreditRemaining()+paymentSchedule.getInstallment());
		allotedCard.setCardCreditUsed(allotedCard.getCardCreditUsed()-paymentSchedule.getInstallment());
		
		
		
		paymentSchedule.setPaymentStatus("true");
		paymentSchedule.setPaymentDate(LocalDate.now());
		
		entityManager.merge(allotedCard);
		entityManager.merge(orderDetail);
		entityManager.merge(paymentSchedule);
		
	}

	


}
