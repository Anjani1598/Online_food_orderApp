package com.masai.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.exceptions.CustomerException;
import com.masai.service.icustomerService.ICustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addBillHandler(@RequestBody Customer customer) throws CustomerException{
		
		Customer addedCustomer = customerService.addCustomer(customer);
		
		return new ResponseEntity<Customer>(addedCustomer,HttpStatus.CREATED);
	}
	

}
