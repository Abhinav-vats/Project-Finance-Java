package com.lti.status;

import com.lti.dto.UserDetailDto;
import com.lti.entity.Customer;

public class UserDetailStatus {

	private int status;
	private String message;
	private String aadhar;
	private String panCard;
	private String blankCheque;
	
	private UserDetailDto userDetailDto;
	
	
	public String getAadhar() {
		return aadhar;
	}
	public String getPanCard() {
		return panCard;
	}
	public String getBlankCheque() {
		return blankCheque;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	public void setBlankCheque(String blankCheque) {
		this.blankCheque = blankCheque;
	}
	public UserDetailDto getUserDetailDto() {
		return userDetailDto;
	}
	public void setUserDetailDto(UserDetailDto userDetailDto) {
		this.userDetailDto = userDetailDto;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
