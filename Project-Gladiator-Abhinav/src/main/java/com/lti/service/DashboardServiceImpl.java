package com.lti.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.CustomerIdDto;
import com.lti.entity.AllotedCard;
import com.lti.entity.OrderDetail;
import com.lti.entity.PaymentSchedule;
import com.lti.helper.CardDashboardDetail;
import com.lti.helper.OrderDashboard;
import com.lti.helper.ProductDashboard;
import com.lti.helper.TransactionDashboard;
import com.lti.repository.DashboardRepository;
import com.lti.service.exception.DashboardServiceException;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private DashboardRepository dashboardRepository;

	@Override
	public CardDashboardDetail fetchReturnDetail(CustomerIdDto customerIdDto) {

		CardDashboardDetail cardDashboardDetail = new CardDashboardDetail();

		AllotedCard allotedCard = dashboardRepository.fetchAllotedCardDetailByUserId(customerIdDto.getId());

		cardDashboardDetail.setCardActivity(allotedCard.getCardActivationStatus());
		cardDashboardDetail.setCardNo(allotedCard.getCardNo());
		cardDashboardDetail.setCardType(allotedCard.getCardType().getType());
		cardDashboardDetail.setCreditRemaining(allotedCard.getCardCreditRemaining());
		cardDashboardDetail.setCreditUsed(allotedCard.getCardCreditUsed());
		cardDashboardDetail.setCvvNo(allotedCard.getCardCvvNo());
		cardDashboardDetail.setName(allotedCard.getCustomer().getFirstName() + " "
				+ allotedCard.getCustomer().getMiddleName() + " " + allotedCard.getCustomer().getLastName());
		cardDashboardDetail.setTotalCredit(allotedCard.getCardType().getMaximumLimit());
		cardDashboardDetail.setValidTill(allotedCard.getValidity());

		return cardDashboardDetail;

	}

	@Override
	public List<ProductDashboard> fetchListForProductDashboard(CustomerIdDto customerIdDto) {

		List<ProductDashboard> productDashboardList = new ArrayList<>();
		List<PaymentSchedule> paymentSchedules = dashboardRepository
				.fetchListOfUnpaidOrderForCurrentMonthByCustomerId(customerIdDto.getId());

		for (PaymentSchedule paymentSchedule : paymentSchedules) {
			if (paymentSchedule.getMonthFor().equalsIgnoreCase(LocalDate.now().getMonth().toString())) {
				ProductDashboard productDashboard = new ProductDashboard();
				productDashboard.setAmount(paymentSchedule.getOrderDetail().getProduct().getCostPerUnit());
				productDashboard.setOrderId(paymentSchedule.getOrderDetail().getOrderId());
				productDashboard.setPaid(paymentSchedule.getOrderDetail().getPricePaid());
				productDashboard.setProductName(paymentSchedule.getOrderDetail().getProduct().getName());
				productDashboard.setPaymentId(paymentSchedule.getPaymentId());
				productDashboardList.add(productDashboard);
			}

		}
		return productDashboardList;

	}

	@Override
	public List<TransactionDashboard> fetchListForTransactionDashboard(CustomerIdDto customerIdDto) {
		List<TransactionDashboard> transactionDashboards = new ArrayList<>();
		List<PaymentSchedule> paymentSchedules = dashboardRepository
				.fetchLastTransactionByCustomer(customerIdDto.getId());

		for (PaymentSchedule paymentSchedule : paymentSchedules) {
			if (ChronoUnit.DAYS.between(paymentSchedule.getPaymentDate(), LocalDate.now()) <= 30) {
				TransactionDashboard transactionDashboard = new TransactionDashboard();
				transactionDashboard.setAmount(paymentSchedule.getInstallment());
				transactionDashboard.setOrderId(paymentSchedule.getOrderDetail().getOrderId());
				transactionDashboard.setProductName(paymentSchedule.getOrderDetail().getProduct().getName());
				transactionDashboard.setPaymentDate(paymentSchedule.getPaymentDate());
				transactionDashboards.add(transactionDashboard);
			}
		}

		return transactionDashboards;

	}

	@Override
	public String payPaymentScheduledById(int id) {
		if (dashboardRepository.isPaymentSchedulePresent(id)) {
			dashboardRepository.updatePaymentScheduleToPaid(id);
			return "Payment Successfull";
		} else {
			throw new DashboardServiceException("This Payment is already completed");
		}
	}

	@Override
	public List<OrderDashboard> fetchListOfOrderByCustomer(int id) {
		List<OrderDetail> orderList = dashboardRepository.fetchOrderByCustomerId(id);
		List<OrderDashboard> orderDashboardList = new ArrayList<>();
		for(OrderDetail orderDetail: orderList) {
			OrderDashboard orderDashboard = new OrderDashboard();
			orderDashboard.setAmountPaid( orderDetail.getPricePaid());
			orderDashboard.setCategory(orderDetail.getProduct().getCategory());
			orderDashboard.setOrderId(orderDetail.getOrderId());
			orderDashboard.setProductName(orderDetail.getProduct().getName());
			orderDashboard.setProductPrice( orderDetail.getProduct().getCostPerUnit());
			orderDashboardList.add(orderDashboard);
		}
		
		
		
		return orderDashboardList;
	}

}
