package com.lti.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.UserDetailDto;
import com.lti.entity.Customer;
import com.lti.repository.UserDetailRepository;
import com.lti.service.exception.CustomerServiceException;
import com.lti.status.UserDetailStatus;
@Service
public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	private UserDetailRepository userDetailRepository;
	
	public UserDetailStatus findById(int id){
	
	
	Customer customer= userDetailRepository.findById(id);
	UserDetailDto userDetailDto = new UserDetailDto();
	BeanUtils.copyProperties(customer, userDetailDto);
	UserDetailStatus status = new UserDetailStatus();
	status.setUserDetailDto(userDetailDto);
	String aadhar;
	String panCard;
	String blankCheque;
	try {
		 aadhar = customer.getDocument().getAadharCard();
		 panCard = customer.getDocument().getPanCard();
		 blankCheque = customer.getDocument().getBlankCheque();
		 status.setStatus(100);
			status.setMessage("Fetched");
			
			status.setAadhar(aadhar);
			status.setPanCard(panCard);
			status.setBlankCheque(blankCheque);
			return status;
	}
	catch(NullPointerException e) {
		throw new CustomerServiceException("Document not available" );
	}
	
	
	
	
	
	}

	
}
