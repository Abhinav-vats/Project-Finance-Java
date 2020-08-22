package com.lti.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
	@RequestMapping(path = "/message" , produces = MediaType.TEXT_PLAIN_VALUE)
	public String displayMessage() {
		return "message is displaying";
	}

}
