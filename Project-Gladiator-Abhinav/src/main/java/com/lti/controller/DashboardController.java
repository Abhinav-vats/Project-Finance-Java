package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.CustomerIdDto;
import com.lti.helper.CardDashboardDetail;
import com.lti.helper.ProductDashboard;
import com.lti.helper.TransactionDashboard;

import com.lti.service.DashboardService;
import com.lti.service.exception.DashboardServiceException;
import com.lti.status.CustomerStatus;
import com.lti.status.DashboardStatus;

@RestController
@CrossOrigin
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;

	@PostMapping("/dashboard")
	public DashboardStatus displayDashboard(@RequestBody CustomerIdDto customerIdDto) {
		try {
			CardDashboardDetail cardDashboardDetail = dashboardService.fetchReturnDetail(customerIdDto);
			List<ProductDashboard> productDashboardList = dashboardService.fetchListForProductDashboard(customerIdDto);
			List<TransactionDashboard> transactionDashboardList = dashboardService
					.fetchListForTransactionDashboard(customerIdDto);
			DashboardStatus dashboardStatus = new DashboardStatus();
			dashboardStatus.setProductList(productDashboardList);
			dashboardStatus.setCardDashboardDetail(cardDashboardDetail);
			dashboardStatus.setTransactionList(transactionDashboardList);

			dashboardStatus.setStatus(100);
			dashboardStatus.setMessage("Fetched Successfully.");

			return dashboardStatus;

		} catch (DashboardServiceException e) {
			DashboardStatus dashboardStatus = new DashboardStatus();

			dashboardStatus.setStatus(101);
			dashboardStatus.setMessage(e.getMessage());

			return dashboardStatus;

		}
	}

	@PostMapping("/paythisschedule")
	public CustomerStatus payThisMonthsPaymentScheduled(@RequestBody CustomerIdDto customerIdDto) {
		try {
			
			String message = dashboardService.payPaymentScheduledById(customerIdDto.getId());
			
			CustomerStatus customerStatus = new CustomerStatus();

			customerStatus.setStatus(101);
			customerStatus.setMessage(message);

			return customerStatus;

		} catch (DashboardServiceException e) {
			CustomerStatus customerStatus = new CustomerStatus();

			customerStatus.setStatus(101);
			customerStatus.setMessage(e.getMessage());

			return customerStatus;
		}
	}

}
