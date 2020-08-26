package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.PaymentSchedule;
import com.lti.repository.PaymentScheduleRepository;
import com.lti.service.exception.PaymentScheduleServiceException;
@Service
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
