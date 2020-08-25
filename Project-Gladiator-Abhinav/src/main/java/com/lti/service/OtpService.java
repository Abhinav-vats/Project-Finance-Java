package com.lti.service;

import com.lti.dto.OtpManagerDto;
import com.lti.service.exception.OtpServiceException;

public interface OtpService {
	
	String otpGenerateAndAdd(String emailId) throws OtpServiceException;
	
	String matchAndRemoveOtp(OtpManagerDto otpManagerDto) throws OtpServiceException;

}
