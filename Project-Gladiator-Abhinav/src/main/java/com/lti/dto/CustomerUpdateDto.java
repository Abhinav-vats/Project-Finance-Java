package com.lti.dto;

import java.time.LocalDate;

import javax.persistence.Column;
public class CustomerUpdateDto {

	private String firstName;

	private String middleName;

	private String lastName;

	private LocalDate dateOfBirth;

	private String phoneNumber;


	private String username;

	

	private String address;

	private String cardType;

	private String bankName;

	private String bankAccountNumber;

	private String ifsCode;

	private String isActive;

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}


	public String getUsername() {
		return username;
	}



	public String getAddress() {
		return address;
	}

	public String getCardType() {
		return cardType;
	}

	public String getBankName() {
		return bankName;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public String getIfsCode() {
		return ifsCode;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

	public void setUsername(String username) {
		this.username = username;
	}

	

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public void setIfsCode(String ifsCode) {
		this.ifsCode = ifsCode;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	
}
