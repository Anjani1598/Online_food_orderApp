package com.masai.service.icustomerService;

import java.util.List;


import com.masai.model.Customer;
import com.masai.model.Restaurant;
import com.masai.model.RestaurantAdmin;
import com.masai.exceptions.CustomerException;
import com.masai.exceptions.RestaurantException;

public interface ICustomerService {
	
	
	public Customer addCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer, String key)throws CustomerException;
	
	public String removeCustomer(Integer customerId, String key)throws CustomerException;
	
	public Customer viewCustomer(String key)throws CustomerException;
	
	public List<Customer> viewAllCustomers(Restaurant rest) throws RestaurantException;

	public RestaurantAdmin addRestaurantAdmin(RestaurantAdmin admin)throws CustomerException;
}
