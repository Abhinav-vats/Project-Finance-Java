package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.OtpManager;

@Repository
public class OtpRepositoryImpl implements OtpRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	
	@Transactional
	public String addNewOtp(String emailId, String otp) {
		
		OtpManager otpManager = new OtpManager();
		otpManager.setEmailId(emailId);
		otpManager.setOtp(otp);
			
		entityManager.merge(otpManager);
		
		return "Otp Saved Successfully";
	}

	
	@Transactional
	public String fetchOtpByEmailId(String emailId) {
		
		return (String) entityManager
				.createQuery("select o.otp from OtpManager as o where o.emailId = :ei")
				.setParameter("ei", emailId)
				.getSingleResult();
	}

	
	@Transactional
	public void removeOtpByEmailId(String emailId) {
		OtpManager otpManager =(OtpManager) entityManager
				.createQuery("select o from OtpManager as o where o.emailId= :ei")
				.setParameter("ei", emailId)
				.getSingleResult();
		
		entityManager.remove(otpManager);
		
		
	}

	
	@Transactional
	public boolean isOtpByEmailPresent(String emailId) {
		
		return (Long) entityManager
				.createQuery("select count(o.id) from OtpManager as o where o.emailId = :ei")
				.setParameter("ei", emailId)
				.getSingleResult()==0?true:false;
	}

}
