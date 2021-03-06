package com.lti.repository;

import java.util.List;

import com.lti.entity.*;

public interface PaymentScheduleRepository {
	
List<PaymentSchedule> getPaymentList();
	
	Customer findById(int id);
	Product findByProductId(int id);
	
	long countPayment();
	
}
