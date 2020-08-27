package com.lti.repository;

import com.lti.entity.Customer;
import com.lti.entity.Document;

public interface UploadRepository {

	Customer fetchCustomerById(int userId);

	void addNewDocument(Document document);

	

	

}
