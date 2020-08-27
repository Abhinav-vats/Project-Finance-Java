package com.lti.service;

import java.util.List;

import com.lti.dto.UploadDocumentDto;
import com.lti.entity.Document;


public interface UploadService {

	

	void save(Document document, int user_id);



}
