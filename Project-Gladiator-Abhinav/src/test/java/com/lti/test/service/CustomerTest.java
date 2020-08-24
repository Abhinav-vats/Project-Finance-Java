package com.lti.test.service;

import java.time.LocalDate;

import org.hibernate.type.ClassType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.lti.dto.CardTypeDto;
import com.lti.entity.Admin;
import com.lti.entity.Customer;
import com.lti.repository.AdminRepository;
import com.lti.repository.CustomerRepository;
import com.lti.service.CustomerService;
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
	
	
	//@Test
	// void addCustomerTest() {
		//Customer customer = new Customer();
		//customer.setFirstName("Nupur");
		/*customer.setMiddleName("k");
		customer.setLastName("jain");
	    customer.setDateOfBirth(LocalDate.of(2, 4, 97));
		customer.setPhoneNumber("9897713538");
		customer.setEmail("nupurjain@gmail.com");
		customer.setUsername("nupi123");
		customer.setPassword("nupi123");
		customer.setAddress("Tropical Dairy Srinagar Garhwal");
		customer.setCardType("gold");
		
		customer.setBankName("hdfc");
		customer.setBankAccountNumber("1234567891234567");
		customer.setIfsCode("hdfin123");
		customerRepository.addCustomer(customer);*/
	//}

	
	}
