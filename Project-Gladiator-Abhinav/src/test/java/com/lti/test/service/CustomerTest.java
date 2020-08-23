package com.lti.test.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.lti.service.CustomerService;
import com.lti.service.exception.CustomerServiceException;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CustomerTest {
	
	@Autowired
	private CustomerService customerService;
	
	@Test
	public void testUsername() {
		
			System.out.println(customerService.checkUsernameAvailability("abhi1234"));
		
	}

}
