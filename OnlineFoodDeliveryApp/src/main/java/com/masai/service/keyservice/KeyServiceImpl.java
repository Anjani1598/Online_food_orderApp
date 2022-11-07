package com.masai.service.keyservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.RestaurantException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.Restaurant;
import com.masai.repositories.CustomerDao;
import com.masai.repositories.RestaurantDao;
import com.masai.repositories.SessionDao;

@Service
public class KeyServiceImpl implements KeyService {
	
	@Autowired
	private SessionDao sessionDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private RestaurantDao restaurantDao;

	@Override
	public CurrentUserSession getLoggedInuserKey(String mobileNumber) throws RestaurantException {
		// TODO Auto-generated method stub
		
		Customer customer = customerDao.findByMobileNumber(mobileNumber);
		
		if(customer!=null) {
			
			CurrentUserSession loggedInuser = sessionDao.findById(customer.getCustomerId()).get();
			
			if(loggedInuser!=null) {
				return loggedInuser;
			}
			throw new RestaurantException("No user found");
		}
		
		throw new RestaurantException("No user found with the given Mobile Number");
		
		
	}

	@Override
	public CurrentUserSession getLoggedInadminKey(String mobileNumber) throws RestaurantException {
		
		Restaurant customer = restaurantDao.findByMobileNumber(mobileNumber);
		
		if(customer!=null) {
			
			CurrentUserSession loggedInuser = sessionDao.findById(customer.getRestaurantId()).get();
			
			if(loggedInuser!=null) {
				return loggedInuser;
			}
			throw new RestaurantException("No user found");
		}
		
		throw new RestaurantException("No user found with the given Mobile Number");
		
	}

}
