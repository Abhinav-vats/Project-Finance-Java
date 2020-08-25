package com.lti.repository;

public interface OtpRepository {
	
	String addNewOtp(String emailId, String otp);
	
	String fetchOtpByEmailId(String emailId);
	
	void removeOtpByEmailId(String emailId);
	
	boolean isOtpByEmailPresent(String emailId);

}
