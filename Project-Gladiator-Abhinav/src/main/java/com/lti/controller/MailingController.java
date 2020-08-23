package com.lti.controller;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.service.MailingService;
import com.lti.status.CustomerStatus;

@RestController
public class MailingController {

	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private MailingService mailService;
	
	@PostMapping(path="/sendotpmail", consumes = "application/json")
	public CustomerStatus sendOtpMail(@RequestBody Mail mail) {
		
		 
		
		String numbers = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      Random random = new Random();
	      String otp = "";

	      for(int i = 0; i< 6 ; i++) {
	         otp =  otp+ numbers.charAt(random.nextInt(numbers.length()));
	      }	
	      
//	      Cookie cookie = new Cookie("otp", otp);
//			 res.addCookie(cookie);
	      
	      try {
	    	  
	    	  String message = mailService.mailIdVerification(otp, mail.getMailid());
	    	  CustomerStatus stat = new CustomerStatus();
	    	  stat.setStatus(100);
	    	  stat.setMessage(message);
	    	  return stat;
	      }
	      catch(MailException e) {
	    	  CustomerStatus stat = new CustomerStatus();
	    	  stat.setStatus(102);
	    	  stat.setMessage(e.getMessage());
	    	  return stat;
	      }
	}
	
	@PostMapping(path = "/checkotp" , consumes = "text/plain")
	public CustomerStatus checkOtpRecieved(@RequestBody String inputOtp, HttpServletRequest req) {
		
		Cookie[] list = req.getCookies();
		try {
			CustomerStatus stat = new CustomerStatus();
		
			if(list[0].getValue().equals(inputOtp)) {
				
		    	  stat.setStatus(100);
		    	  stat.setMessage("Email Verified");
		    	  return stat;
			}
			else {
				stat.setStatus(101);
		    	  stat.setMessage("OTP entered is wrong");
		    	  return stat;
			}
		}
		catch(Exception e) {
			CustomerStatus stat = new CustomerStatus();
			stat.setStatus(102);
	    	  stat.setMessage("Error Occured in fetching Data. Please reverify");
	    	  return stat;

		}
		
		
	
	}
	
	public static class Mail{
		private String mailid;

		public String getMailid() {
			return mailid;
		}

		public void setMailid(String mailid) {
			this.mailid = mailid;
		}
		
		
	}
	
}
