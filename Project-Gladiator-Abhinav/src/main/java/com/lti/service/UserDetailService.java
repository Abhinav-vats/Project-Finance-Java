package com.lti.service;

import java.util.List;

import com.lti.entity.Customer;
import com.lti.service.exception.DocumentServiceException;

public interface UserDetailService {

	Customer findById(int id);

	String fetchAadhar(int id) throws DocumentServiceException;

	String fetchPanCard(int id) throws DocumentServiceException;

	String fetchBlankCheque(int id) throws DocumentServiceException;
}