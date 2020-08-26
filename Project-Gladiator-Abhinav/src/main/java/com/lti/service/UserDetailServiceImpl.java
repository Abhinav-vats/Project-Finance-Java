package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Customer;
import com.lti.repository.UserDetailRepository;
import com.lti.service.exception.DocumentServiceException;
@Service
public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	private UserDetailRepository userDetailRepository;
	
	public Customer findById(int id){
	return userDetailRepository.findById(id);
	}

	@Override
	public String fetchAadhar(int id) throws DocumentServiceException {
		if(userDetailRepository.isAadharAvailable(id)) {
			return userDetailRepository.aadharDocumentPath(id);
		}
		else {
			throw new DocumentServiceException("Aadhar card not available");
		}
		
	}

	@Override
	public String fetchPanCard(int id) throws DocumentServiceException {
		if(userDetailRepository.isPanCardAvailable(id)) {
			return userDetailRepository.panCardDocumentPath(id);
		}
		else {
			throw new DocumentServiceException("Pan card not available");
		}
	}

	@Override
	public String fetchBlankCheque(int id) throws DocumentServiceException {
		if(userDetailRepository.isBlankChequeAvailable(id)) {
			return userDetailRepository.blankChequeDocumentPath(id);
		}
		else {
			throw new DocumentServiceException("Blank canceled cheque not available");
		}
	}
}
