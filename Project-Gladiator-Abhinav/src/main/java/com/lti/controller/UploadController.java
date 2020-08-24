package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.UploadDocumentDto;
import com.lti.entity.Customer;
import com.lti.service.UploadService;
import com.lti.status.CustomerStatus;

@RestController
@CrossOrigin
public class UploadController {
	
	@Autowired
	private UploadService uploadService;
	
	@PostMapping(path = "/uploadDoc", consumes = "multipart/form-data")
	public CustomerStatus uploadDoc(List<UploadDocumentDto> uploadDocumentDtos) {
		try {
			String message = uploadService.saveDocumentsFromDtoList(uploadDocumentDtos);
			CustomerStatus customerStatus = new CustomerStatus();
			customerStatus.setMessage(message);
			customerStatus.setStatus(100);
			
			return customerStatus;
		}
		catch(Exception e) {
			CustomerStatus customerStatus = new CustomerStatus();
			customerStatus.setStatus(101);
			customerStatus.setMessage(e.getMessage());
			return customerStatus;
		}
		
	}
	

}
