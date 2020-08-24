package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.LoginDto;
import com.lti.service.LoginService;
import com.lti.service.exception.LoginException;
import com.lti.status.LoginReturnStatus;

@RestController
@CrossOrigin
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping(path = "/login")
	public LoginReturnStatus loginControll(@RequestBody LoginDto loginDto) {
		try {
			if(loginDto.getUserType().equals("Admin")) {
				return loginService.loginAdmin(loginDto);
			}
			else {
				return  loginService.loginCustomer(loginDto);
			}
			
		}
		catch(LoginException e) {
			LoginReturnStatus loginReturnStatus = new LoginReturnStatus();
			
			loginReturnStatus.setActiveStatus(false);
			loginReturnStatus.setDocumentUploadedStatus(false);
			loginReturnStatus.setMessage(e.getMessage());
			loginReturnStatus.setStatus(101);
			loginReturnStatus.setUserId(-100);
			loginReturnStatus.setUserType(loginDto.getUserType());
			
			
			return loginReturnStatus;
		}
	}

}
