package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.entity.*;
import com.lti.repository.*;
import com.lti.service.exception.*;

public class PaymentScheduleServiceImpl implements PaymentScheduleService {

	@Autowired
	private PaymentScheduleRepository paymentRepo;
	
	
	@Override
	public List<PaymentSchedule> displayPayment() throws PaymentScheduleServiceException {
		if(paymentRepo.countPayment()>0)
			return paymentRepo.getPaymentList();
		else 
			throw new PaymentScheduleServiceException("No Payments yet.");
	}

}
