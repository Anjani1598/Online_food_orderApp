package com.masai.service.icustomerService;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Address;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.Restaurant;
import com.masai.exceptions.CustomerException;
import com.masai.exceptions.RestaurantException;
import com.masai.repositories.CustomerDao;
import com.masai.repositories.SessionDao;


@Service
public class ICustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private SessionDao sessionDao;
	

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
			throw new CustomerException("Invalid CustomerId");
		}
	}

	@Override
	public Customer removeCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer viewCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> viewAllCustomers(Restaurant rest) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
