package com.lti.status;

public class LoginReturnStatus {
	
	private int status;
	private String message;
	private int userId;
	private String userType;
	private boolean activeStatus;
	private boolean documentUploadedStatus;
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public int getUserId() {
		return userId;
	}
	public String getUserType() {
		return userType;
	}
	public boolean isActiveStatus() {
		return activeStatus;
	}
	public boolean isDocumentUploadedStatus() {
		return documentUploadedStatus;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}
	public void setDocumentUploadedStatus(boolean documentUploadedStatus) {
		this.documentUploadedStatus = documentUploadedStatus;
	}

	
}
