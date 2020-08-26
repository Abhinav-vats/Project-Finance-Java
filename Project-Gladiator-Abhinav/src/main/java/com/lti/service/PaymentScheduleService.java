package com.lti.service;

import java.util.List;

import com.lti.entity.PaymentSchedule;
import com.lti.service.exception.PaymentScheduleServiceException;

public interface PaymentScheduleService {
	
	List<PaymentSchedule> displayPayment() throws PaymentScheduleServiceException;

}
