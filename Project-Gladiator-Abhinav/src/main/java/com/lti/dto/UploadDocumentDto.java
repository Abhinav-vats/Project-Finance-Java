package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class UploadDocumentDto {
	
	private int userId;
	
	private MultipartFile aadharCard;
	
	private MultipartFile panCard;
	
	private MultipartFile blankCheque;
	
	
	
	
	


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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
