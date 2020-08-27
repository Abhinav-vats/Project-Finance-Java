package com.lti.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.lti.dto.UploadDocumentDto;
import com.lti.entity.Customer;
import com.lti.entity.Document;
import com.lti.repository.UploadRepository;

@Service
public class UploadServiceImpl implements UploadService {
	
	@Autowired
	private UploadRepository uploadRepository;

	@Override
	public void save(Document document, int userId) {
		Customer customer = uploadRepository.fetchCustomerById(userId);
		
		document.setCustomer(customer);
		
		uploadRepository.addNewDocument(document);
		
		
	}

	

}
