package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.exceptions.CustomerException;
import com.masai.service.icustomerService.ICustomerService;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomerHandler(@RequestBody Customer customer) throws CustomerException{
		
		Customer addedCustomer = customerService.addCustomer(customer);
		
		return new ResponseEntity<Customer>(addedCustomer,HttpStatus.CREATED);
	}
	
	@PutMapping("/customers")
	public  ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,@RequestParam(required = false) String key ) throws CustomerException {
		
		
		Customer updatedCustomer= customerService.updateCustomer(customer, key);
				
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/customers")
	public  ResponseEntity<String> removeCustomer(@RequestParam Integer customerId,@RequestParam(required = false) String key ) throws CustomerException {
		
		
		String deletedCustomer= customerService.removeCustomer(customerId, key);
				
		return new ResponseEntity<String>(deletedCustomer,HttpStatus.OK);
		
	}
	
	@GetMapping("/customers")
	public  ResponseEntity<Customer> viewCustomer(@RequestParam(required = false) String key ) throws CustomerException {
		
		
		Customer Customer= customerService.viewCustomer(key);
				
		return new ResponseEntity<Customer>(Customer,HttpStatus.OK);
		
	}
	
	
	
	
	

}
