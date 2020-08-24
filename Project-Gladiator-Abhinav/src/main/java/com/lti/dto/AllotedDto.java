package com.lti.dto;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.entity.AllotedCard;
import com.lti.entity.Customer;

public class AllotedDto {
	private int userid;
	private String cardCvvNo;
	private String cardNo;
	private LocalDate validity;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getCardCvvNo() {
		return cardCvvNo;
	}

	public void setCardCvvNo(String cardCvvNo) {
		this.cardCvvNo = cardCvvNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public LocalDate getValidity() {
		return validity;
	}

	public void setValidity(LocalDate validity) {
		this.validity = validity;
	}

}
