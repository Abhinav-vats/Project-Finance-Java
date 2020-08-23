package com.lti.test.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.lti.entity.Admin;
import com.lti.repository.AdminRepository;
import com.lti.service.CustomerService;
import com.lti.service.exception.CustomerServiceException;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CustomerTest {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Test
	public void testUsername() {
		
			System.out.println(customerService.checkUsernameAvailability("abhi1234"));
		
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

}
