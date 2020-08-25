package com.lti.service;

import com.lti.dto.AllotedDto;
import com.lti.dto.UpdateCustomerDto;

public interface AllotedCardService {
	


	String addCard(AllotedDto allotedDto);

	String updateCustomer(UpdateCustomerDto updateCustomerdto);
}
