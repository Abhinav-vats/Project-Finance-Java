package com.lti.service;

import java.util.List;

import com.lti.dto.UploadDocumentDto;


public interface UploadService {

	String saveDocumentsFromDtoList(List<UploadDocumentDto> uploadDocumentDtos);



}
