package com.lti.controller;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.UploadDocumentDto;
import com.lti.entity.Customer;
import com.lti.entity.Document;
import com.lti.service.UploadService;
import com.lti.status.CustomerStatus;

@RestController
@CrossOrigin
public class UploadController {
	
	@Autowired
	private UploadService uploadService;
	
	@PostMapping(path = "/uploadDoc")
	public CustomerStatus upload( UploadDocumentDto uploadDocDto) {
		String uploadLocation = "d:/upload/";
		
		String customerAadharCard = uploadDocDto.getAadharCard().getOriginalFilename();
		String customerAadharCardFile = uploadLocation + customerAadharCard;
		
		String customerPanCard = uploadDocDto.getPanCard().getOriginalFilename();
		String customerPanCardFile = uploadLocation + customerPanCard;
		
		String customerBlankCheque = uploadDocDto.getBlankCheque().getOriginalFilename();
		String customerBlankChequeFile = uploadLocation + customerBlankCheque;
		
		System.out.println(customerAadharCard);
		System.out.println(customerPanCard);
		System.out.println(customerBlankCheque);
		
		
		
		
		try {
			FileCopyUtils.copy(uploadDocDto.getAadharCard().getInputStream(), new FileOutputStream(customerAadharCardFile));
			FileCopyUtils.copy(uploadDocDto.getPanCard().getInputStream(), new FileOutputStream(customerPanCardFile));
			FileCopyUtils.copy(uploadDocDto.getBlankCheque().getInputStream(), new FileOutputStream(customerBlankChequeFile));
			
		} catch (IOException e) {
			e.printStackTrace();
			CustomerStatus status = new CustomerStatus();
			status.setStatus(101);
			status.setMessage(e.getMessage());
			return status;
		}

		
		Document document = new Document();
		document.setAadharCard(customerAadharCardFile);
		document.setPanCard(customerPanCardFile);
		document.setBlankCheque(customerBlankChequeFile);
		
		int id = Integer.parseInt(uploadDocDto.getUserId());
		
		uploadService.save(document, id);
		
		CustomerStatus status = new CustomerStatus();
		status.setStatus(100);
		status.setMessage("Uploaded!");
		return status;
	}
}