package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.lti.dto.CustomerUpdateDto;
import com.lti.entity.Customer;
import com.lti.repository.CustomerRepository;
import com.lti.repository.CustomerUpdateRepository;
import com.lti.service.exception.CustomerServiceException;
import com.lti.status.UsernameStatus;


@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerRepository customerRepository;
	private CustomerUpdateRepository customerUpdateRepository;
	
	public void register(Customer customer) throws  CustomerServiceException{
		if(!customerRepository.isCustomerAvailable(customer.getEmail())) {
			customerRepository.addCustomer(customer);
		}
		else 
			throw new CustomerServiceException("Customer Already Registered");
		
	}



	public List<Customer> displayCustomer() throws CustomerServiceException{
		
	if(customerRepository.countCustomer()>0)
		return customerRepository.getUserList();
	else 
		throw new CustomerServiceException("No Customer Available");
}
	
	
	//private Customer toEntity(CustomerUpdateDto customerUpdateDto) {
		private Customer toEntity(CustomerUpdateDto customerUpdateDto) {
        Customer cust = new Customer();
        cust.setFirstName(customerUpdateDto.getFirstName());
        
        return cust;
    }
	

	    public void add(CustomerUpdateDto customerUpdateDto) {
	        customerUpdateRepository.save(toEntity(customerUpdateDto));
	    }

	

	public void delete(int id) throws  CustomerServiceException{
		if(customerRepository.isPresent(id)) {
			customerRepository.delete(id);
		}
		else 
			throw new CustomerServiceException("Customer Already Removed");
		
	}

	@Override
	public UsernameStatus checkUsernameAvailability(String username) throws  CustomerServiceException {
		UsernameStatus usernameStatus = new UsernameStatus();
		if(customerRepository.isUsernameAvailable(username)) {
			
			usernameStatus.setStatus(100);
			usernameStatus.setMessage("Username available");
			return usernameStatus;
		}
		else {
			usernameStatus.setStatus(104);
			usernameStatus.setMessage("Username Not Available, please try new username");
			return usernameStatus;
		}
			
		
			
	}



	
	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}





	

}
