package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.PaymentScheduleDto;
import com.lti.entity.PaymentSchedule;
import com.lti.service.PaymentScheduleService;
import com.lti.service.exception.OrderDetailServiceException;
import com.lti.service.exception.PaymentScheduleServiceException;
import com.lti.status.OrderDetailStatus;
import com.lti.status.PaymentScheduleStatus;

@RestController
@CrossOrigin
public class PaymentScheduleController {
	@Autowired
	private PaymentScheduleService paymentScheduleService;
	
	@RequestMapping(path = "/paymentschedule", produces = "application/json")
	public PaymentScheduleStatus indexDisplay() throws PaymentScheduleServiceException {
		try {
			List<PaymentSchedule> paymentScheduleList = paymentScheduleService.displayPayment();
			PaymentScheduleStatus stat = new PaymentScheduleStatus();
			List<PaymentScheduleDto> o = new ArrayList();
			for(PaymentSchedule l: paymentScheduleList ) {
				PaymentScheduleDto ol = new PaymentScheduleDto();
				ol.setPaymentId(l.getPaymentId());
				ol.setMonthCount(l.getMonthCount());
				ol.setMonthFor(l.getMonthFor());
				ol.setPaymentStatus(l.getPaymentStatus());
				//ol.setPlanid(l.getPlanType().getPlanId());
				ol.setOrderid(l.getOrderDetail().getOrderId());
				ol.setUserid(l.getCustomer().getId());
				ol.setPaymentDate(l.getPaymentDate());
				o.add(ol);
				
			}
			stat.setStatus(106);
			stat.setMessage("Payment Schedule Loaded Successfully");
			stat.setPaymentScheduleList(o);
			return stat;
		}
		catch(PaymentScheduleServiceException e) {
		PaymentScheduleStatus stat = new PaymentScheduleStatus();
		stat.setStatus(107);
		stat.setMessage(e.getMessage());
		return stat;
	}

	}
	
}
