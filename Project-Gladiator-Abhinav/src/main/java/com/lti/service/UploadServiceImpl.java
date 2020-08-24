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
	public String saveDocumentsFromDtoList(List<UploadDocumentDto> uploadDocumentDtos) {
		for( UploadDocumentDto uploadDocumentDto : uploadDocumentDtos) {
			Customer customer = uploadRepository.fetchCustomerById(uploadDocumentDto.getUserId());
			Document document = new Document();
			document.setDocumentType(uploadDocumentDto.getDocumentType());
			document.setVerificationStatus("false");
			document.setCustomer(customer);
						
			String ROOT_DIR = "d:/uploads";
			String fileName = uploadDocumentDto.getDocument().getOriginalFilename();
			String targetPath = ROOT_DIR + fileName ;
			
			try {
				FileCopyUtils.copy(uploadDocumentDto.getDocument().getInputStream()	, new FileOutputStream(targetPath));
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				//should return status indicating  failure
				return e.getMessage();
			}
			
			document.setDocumentPath(targetPath);
			
			uploadRepository.saveDocument(document);
			
			
			
		}
		
		return "Files added successfully";

	}

}
