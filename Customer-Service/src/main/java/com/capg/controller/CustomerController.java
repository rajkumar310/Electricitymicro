package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Customer;
import com.capg.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.addCustomer(customer),HttpStatus.CREATED);
	}
	@GetMapping("/")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id){
		Customer customer=customerService.getById(id);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomerbyId(@PathVariable int id){
		customerService.deleteCustomerById(id);
		return ResponseEntity.ok("Id is deleted successfully............"+id);
	}
	@DeleteMapping("/")
	public ResponseEntity<String> deleteAll(){
		customerService.deleteAll();
		return ResponseEntity.ok("Deleted all customer details");
	}
	@PutMapping("/{id}")
	public ResponseEntity<Customer> editCustomerbyId(@PathVariable("id") int id ,@RequestBody Customer updatedCustomer){
		try {
            Customer customer = customerService.editCustomerById(id, updatedCustomer);
            return ResponseEntity.ok(customer);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
	
	

}
