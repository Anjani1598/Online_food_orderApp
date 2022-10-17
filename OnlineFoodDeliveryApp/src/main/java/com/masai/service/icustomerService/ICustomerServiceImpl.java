package com.masai.service.icustomerService;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Address;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.Restaurant;
import com.masai.model.RestaurantAdmin;
import com.masai.exceptions.CustomerException;
import com.masai.exceptions.RestaurantException;
import com.masai.repositories.AdminDao;
import com.masai.repositories.CustomerDao;
import com.masai.repositories.SessionDao;


@Service
public class ICustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private SessionDao sessionDao;
	
	@Autowired
	private AdminDao adminDao;
	

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		
		Customer existingCustomer= customerDao.findByMobileNumber(customer.getMobileNumber());
		
		
		
		if(existingCustomer != null) 
			throw new CustomerException("Customer Already Registered with Mobile number");
			
		
		
		
			return customerDao.save(customer);	
	}

	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException {
		
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		if(loggedInUser==null) {
			throw new CustomerException("Please provide valid key");
			
		}
		
		if(customer.getCustomerId()==loggedInUser.getUserId()) {
			return customerDao.save(customer);
		}else {
			throw new CustomerException("Invalid Customer Details");
		}
	}

	@Override
	public String removeCustomer(Integer customerId, String key) throws CustomerException {
		
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		if(customerId==loggedInUser.getUserId()) {
			
			Customer cus = customerDao.findById(customerId).get();
			customerDao.delete(cus);
			return "Customer Removed Successfully";
		}else {
			throw new CustomerException("Invalid Customer Details");
		}

	}

	@Override
	public Customer viewCustomer(String key) throws CustomerException {
		
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);

		Optional<Customer> opt = customerDao.findById(loggedInUser.getUserId());
		
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new CustomerException("Invalid Details");
			
			
		}
	}

	@Override
	public List<Customer> viewAllCustomers(Restaurant rest) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestaurantAdmin addRestaurantAdmin(RestaurantAdmin admin) throws CustomerException {

		
		RestaurantAdmin existingAdmin = adminDao.findByMobileNumber(admin.getMobileNumber());
		
		
		if(existingAdmin != null) 
			throw new CustomerException("Admin Already Registered with Mobile number");
			
		
		
		
			return adminDao.save(admin);
	}
	
	
	

}
