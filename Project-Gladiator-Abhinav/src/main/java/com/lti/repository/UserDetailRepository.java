package com.lti.repository;

import com.lti.entity.Customer;

public interface UserDetailRepository {

	Customer findById(int id);

	boolean isAadharAvailable(int id);

	String aadharDocumentPath(int id);

	boolean isPanCardAvailable(int id);

	String panCardDocumentPath(int id);

	boolean isBlankChequeAvailable(int id);

	String blankChequeDocumentPath(int id);

}