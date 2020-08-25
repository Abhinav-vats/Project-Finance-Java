package com.lti.service;

import java.util.List;

import com.lti.entity.*;
import com.lti.service.exception.*;

public interface PaymentScheduleService {
	
	List<PaymentSchedule> displayPayment() throws PaymentScheduleServiceException;

}
