package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.CustomerUpdateDTO;
import com.lti.entity.Customer;
import com.lti.repository.CustomerRepository;
import com.lti.service.exception.CustomerServiceException;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	public void register(Customer customer) throws  CustomerServiceException{
		if(!customerRepository.isCustomerAvailable(customer.getEmail())) {
			customerRepository.addCustomer(customer);
		}
		else 
			throw new CustomerServiceException("Customer Already Registered");
		
	}


	public List<Customer> getAllUser() throws CustomerServiceException{
		
	if(customerRepository.countCustomer()>0)
		return customerRepository.getAllUser();
	else 
		throw new CustomerServiceException("No Customer Available");
}
	
	
	private Customer toEntity(CustomerUpdateDTO customerUpdateDTO) {
        Customer cust = new Customer();
        cust.setFirstName(customerUpdateDTO.getFirstName());
        
        return cust;
    }
	
	

	@Override
	public void delete(int id) {
		
		customerRepository.deleteById(id);
	}


	@Override
	public void updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
		// TODO Auto-generated method stub
		
	}
	
	

	

}
