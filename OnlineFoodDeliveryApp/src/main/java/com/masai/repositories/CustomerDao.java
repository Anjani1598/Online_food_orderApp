package com.masai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.masai.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, String> {
	
	
	public Customer findByMobileNumber(String mobileNumber);
	
	

}
