package com.lti.repository;

import java.util.Base64;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Admin;


@Repository
public class AdminRepositoryImpl implements AdminRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void addAdmin(Admin admin) {
		String password = admin.getPassword();
		String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
		admin.setPassword(encodedPassword);
		entityManager.merge(admin);

	}

	@Override
	public Admin diplayAdminById(int id , String password) {
		
		String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
		
		return (Admin) entityManager
				.createQuery("select a from Admin as a where a.id= :id and a.password= :pw")
				.setParameter("id", id)
				.setParameter("pw", encodedPassword)
				.getSingleResult();
	}

}
