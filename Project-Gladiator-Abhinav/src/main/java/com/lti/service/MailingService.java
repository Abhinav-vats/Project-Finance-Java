package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailingService {
	
	@Autowired
	private MailSender mailSender;
	
	public String mailIdVerification(String otp, String toMail) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		
			message.setFrom("anonymousabhi123up@gmail.com");
			message.setTo(toMail);
			message.setSubject("no reply");
			message.setText("Your email verification one time password is "+otp);
			return "Message send Successfully";
		
	}

}
