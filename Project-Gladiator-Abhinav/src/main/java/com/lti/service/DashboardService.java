package com.lti.service;

import java.util.List;

import com.lti.dto.CustomerIdDto;
import com.lti.helper.CardDashboardDetail;
import com.lti.helper.ProductDashboard;
import com.lti.helper.TransactionDashboard;

public interface DashboardService {

	CardDashboardDetail fetchReturnDetail(CustomerIdDto customerIdDto);

	List<ProductDashboard> fetchListForProductDashboard(CustomerIdDto customerIdDto);

	List<TransactionDashboard> fetchListForTransactionDashboard(CustomerIdDto customerIdDto);

	String payPaymentScheduledById(int id);

}
