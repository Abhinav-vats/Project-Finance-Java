package com.lti.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.OtpManagerDto;
import com.lti.repository.OtpRepository;
import com.lti.service.exception.OtpServiceException;

@Service
public class OtpServiceImpl implements OtpService {
	
	@Autowired
	private OtpRepository otpRepository;

	@Override
	public String otpGenerateAndAdd(String emailId) throws OtpServiceException{
		
		String numbers = "1234567890";
	      Random random = new Random();
	      String otp = "";

	      for(int i = 0; i< 6 ; i++) {
	         otp= otp+ numbers.charAt(random.nextInt(numbers.length()));
	      }
	      
	      if(otpRepository.isOtpByEmailPresent(emailId)) {
	    	  otpRepository.addNewOtp(emailId, otp);
	    	  return otp;
	      }
	      else {
	    	  throw new OtpServiceException("Otp by this email id is already present");
	      }
	      
	}

	@Override
	public String matchAndRemoveOtp(OtpManagerDto otpManagerDto) throws OtpServiceException {
		String otpFetched = otpRepository.fetchOtpByEmailId(otpManagerDto.getEmailId());
		String otpRecieved =otpManagerDto.getOtpRecieved(); 
		
		if(otpFetched.equals(otpRecieved)) {
			otpRepository.removeOtpByEmailId(otpManagerDto.getEmailId());
			return "Otp Match, email verfied ";
		}
		else {
			throw new OtpServiceException("Otp not matched please reverify email");
		}
	}
}
