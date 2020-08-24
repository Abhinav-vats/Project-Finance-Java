package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.CustomerDto;
import com.lti.entity.AllotedCard;
import com.lti.repository.AllotedCardRepository;
import com.lti.service.CustomerService;
import com.lti.status.CustomerStatus;

@RestController
@CrossOrigin
public class AllotedCardController {

	@Autowired
	private AllotedCardRepository allotedCardReopsitory;
	
	@PostMapping("/allotedCardDetail")
	public List<AllotedCard> getAllotedCard(){
			List<AllotedCard> list = allotedCardReopsitory.alloctedCard();
			return list;
			
			
		
	}
}