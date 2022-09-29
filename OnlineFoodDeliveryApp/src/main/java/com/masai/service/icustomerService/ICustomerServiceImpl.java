package com.masai.service.icustomerService;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Address;
import com.masai.model.Customer;
import com.masai.model.Restaurant;
import com.masai.exceptions.CustomerException;
import com.masai.exceptions.RestaurantException;
import com.masai.repositories.CustomerDao;


@Service
public class ICustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		
		if(customer.getCustomerId()==null) {
			return customerDao.save(customer);
		}else
			throw new CustomerException("Customer already exists");
		
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
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
