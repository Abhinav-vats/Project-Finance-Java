package com.lti.repository;

import java.util.List;

import com.lti.dto.CustomerIdDto;
import com.lti.entity.AllotedCard;
import com.lti.entity.OrderDetail;
import com.lti.entity.PaymentSchedule;
import com.lti.helper.OrderDashboard;
import com.lti.helper.ProductDashboard;

public interface DashboardRepository {

	AllotedCard fetchAllotedCardDetailByUserId(int i);

	List<PaymentSchedule> fetchListOfUnpaidOrderForCurrentMonthByCustomerId(int i);

	List<PaymentSchedule> fetchLastTransactionByCustomer(int i);

	boolean isAllotedCardPresent(int id);

	boolean isUnpaidOrderLeftForCustomerById(int id);

	boolean isPaymentSchedulePresent(int id);

	void updatePaymentScheduleToPaid(int id);

	List<OrderDetail> fetchOrderByCustomerId(int id);

	

}
