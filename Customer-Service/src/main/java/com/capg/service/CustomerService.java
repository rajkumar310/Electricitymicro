package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Customer;
import com.capg.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	 @Autowired
	 public CustomerService(CustomerRepository customerRepository) {
	        this.customerRepository = customerRepository;
	    }

	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	public Customer getById(int id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id).get();
	}

	

	public  void deleteCustomerById(int id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		customerRepository.deleteAll();
		
	}

	public Customer editCustomerById(int id, Customer updatedCustomer) {
		 if (customerRepository.existsById(id)) {
	            updatedCustomer.setCustomerId(id);
	            return customerRepository.save(updatedCustomer);
	        } else {
	            // Handle the case where the Customer with the given ID doesn't exist.
	            // This might involve throwing an exception or returning null.
	            throw new RuntimeException("Customer not found for id: " + id);
	        }
	}

	

}
