package com.lti.test.service;
import com.lti.entity.*;

import java.util.List;

import java.time.LocalDate;

import org.hibernate.type.ClassType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;


import com.lti.dto.OtpManagerDto;

import com.lti.entity.Admin;
import com.lti.entity.Customer;
import com.lti.repository.AdminRepository;

import com.lti.repository.CustomerRepository;
import com.lti.repository.OrderDetailRepositoryImpl;
import com.lti.repository.OtpRepositoryImpl;


import com.lti.service.CustomerService;
import com.lti.service.OtpServiceImpl;
import com.lti.service.exception.CustomerServiceException;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CustomerTest {
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Test
	public void testUsername() {
		
			System.out.println(customerService.checkUsernameAvailability("abhi1234"));
		
	}
	
	@Test
	void fetchorder() {
		
		OrderDetailRepositoryImpl a = new OrderDetailRepositoryImpl();
		List<OrderDetail> l = a.getOrderList();
		for(OrderDetail o:l) {
			System.out.println(o.getOrderId());
		}
		
		
	}
	
	@Test
	void adminRepoAddAdminTest() {
		
		Admin admin = new Admin();
		admin.setFirstName("Neeraj");
		admin.setMiddleName("Kumar");
		admin.setLatsName("Maurya");
		admin.setEmailId("neeraj123up@gmail.com");
		admin.setPhoneNumber("9854160527");
		admin.setUsername("neeraj123");
		admin.setPassword("neeraj123");
		
		adminRepository.addAdmin(admin);
		
		
		
	}
	
	
	@Test
	void adminFetchTest() {
		Admin admin = adminRepository.diplayAdminById(162, "abhi123");
		
		System.out.println(admin.getFirstName()+" "+admin.getLatsName());
		
	}
	

	

	@Test
	void testFetchOtpbymail() {
		
		OtpManagerDto o = new OtpManagerDto();
		o.setEmailId("abhi123up@gmail.com");
		o.setOtpRecieved("771051");
		OtpServiceImpl serv = new OtpServiceImpl();
		OtpRepositoryImpl repo = new OtpRepositoryImpl();
		System.out.println(repo.fetchOtpByEmailId(o.getEmailId()));
		
		
		
	}


	
	}
