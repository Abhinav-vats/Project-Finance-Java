package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class UploadDocumentDto {
	
	private int userId;
	private String documentType;
	private MultipartFile document;
	public int getUserId() {
		return userId;
	}
	public String getDocumentType() {
		return documentType;
	}
	public MultipartFile getDocument() {
		return document;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public void setDocument(MultipartFile document) {
		this.document = document;
	}
	
	

}
