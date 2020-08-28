package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class UploadDocumentDto {

	private String userId;

	private MultipartFile aadharCard;

	private MultipartFile panCard;

	private MultipartFile blankCheque;

	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public MultipartFile getAadharCard() {
		return aadharCard;
	}

	public MultipartFile getPanCard() {
		return panCard;
	}

	public MultipartFile getBlankCheque() {
		return blankCheque;
	}

	public void setAadharCard(MultipartFile aadharCard) {
		this.aadharCard = aadharCard;
	}

	public void setPanCard(MultipartFile panCard) {
		this.panCard = panCard;
	}

	public void setBlankCheque(MultipartFile blankCheque) {
		this.blankCheque = blankCheque;
	}

}
