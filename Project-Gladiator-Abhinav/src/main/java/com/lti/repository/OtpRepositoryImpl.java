package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.OtpManager;

@Repository
public class OtpRepositoryImpl implements OtpRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public String addNewOtp(String emailId, String otp) {
		
		OtpManager otpManager = new OtpManager();
		otpManager.setEmailId(emailId);
		otpManager.setOtp(otp);
			
		entityManager.merge(otpManager);
		
		return "Otp Saved Successfully";
	}

	@Override
	public String fetchOtpByEmailId(String emailId) {
		
		return (String) entityManager
				.createQuery("select o.otp from OtpManager as o where o.emailId = :ei")
				.setParameter("ei", emailId)
				.getSingleResult();
	}

	@Override
	public void removeOtpByEmailId(String emailId) {
		OtpManager otpManager =(OtpManager) entityManager
				.createQuery("select o from OtpManager as o where o.email= :ei")
				.setParameter("ei", emailId)
				.getSingleResult();
		
		entityManager.remove(otpManager);
		
		
	}

	@Override
	public boolean isOtpByEmailPresent(String emailId) {
		
		return (Long) entityManager
				.createQuery("select count(o.id) from OtpManager as o where o.emailId = :ei")
				.setParameter("ei", emailId)
				.getSingleResult()==1?true:false;
	}

}
