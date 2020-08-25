package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.lti.dto.AllotedDto;
import com.lti.dto.UpdateCustomerDto;
import com.lti.entity.AllotedCard;
import com.lti.entity.CardType;
import com.lti.entity.Customer;
import com.lti.repository.AllotedCardRepository;
import com.lti.service.exception.AllotedCardServiceException;


@Service
public class AllotedCardServiceImp implements AllotedCardService {
	
	@Autowired
	private AllotedCardRepository allotedCardRepository;

	@Override
	public String addCard(AllotedDto allotedDto) throws AllotedCardServiceException{
		if(!allotedCardRepository.isCardPresent(allotedDto.getCardNo())){
		AllotedCard allotedCard = new AllotedCard();
		allotedCard.setCardNo(allotedDto.getCardNo());
		allotedCard.setCardCvvNo(Integer.parseInt(allotedDto.getCardCvvNo()));
		allotedCard.setValidity(allotedDto.getValidity());
		allotedCard.setCardActivationStatus("Activated");
		
		Customer customer = allotedCardRepository.findCustomerById(allotedDto.getUserid());
		allotedCard.setCustomer(customer);
		CardType cardType = allotedCardRepository.fetchCardType(customer.getCardType());
		allotedCard.setCardType(cardType);
		
		allotedCard.setCardCreditRemaining(cardType.getMaximumLimit());
		allotedCardRepository.addAllotedCard(allotedCard);
		return "Card Added sucessfully";
		
		}
		else {
			throw new AllotedCardServiceException("Card Number Not Available");
		}
		
	}

	@Override
	public String updateCustomer(UpdateCustomerDto updateCustomerdto) {
		Customer customer = allotedCardRepository.findCustomerById(updateCustomerdto.getId());
		customer.setIsActive("true");
		allotedCardRepository.updateCustomer(customer);
		return "Customer activated sucessfully";
	}


	
}