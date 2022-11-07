package com.masai.service.iRestaurantService;


import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.RestaurantException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Restaurant;
import com.masai.repositories.AdminDao;
import com.masai.repositories.RestaurantDao;
import com.masai.repositories.SessionDao;

@Service
public class IRestaurantServiceImpl implements IRestaurantService{

	
	@Autowired
	private RestaurantDao restaurantDao; 
	
	@Autowired
	private SessionDao sessionDao;
	
	@Autowired
	private AdminDao adminDao;
	
	
	
	@Override
	public Restaurant addRestaurant(Restaurant res) throws RestaurantException, CustomerException {
		
		 Restaurant existingCustomer= restaurantDao.findByMobileNumber(res.getMobileNumber());
		 
		 if(existingCustomer != null) 
				throw new CustomerException("Customer Already Registered with Mobile number");
		 		Float rating = ThreadLocalRandom.current().nextFloat(1, 4 + 1);
		 		Float deliveryTime = ThreadLocalRandom.current().nextFloat(10, 60 + 1);

		 		int discount = ThreadLocalRandom.current().nextInt(10, 59 + 1);
				res.setDeliveryTime(deliveryTime);
				res.setRating(rating);
				res.setDiscount(discount);
				return restaurantDao.save(res);	
	}

	@Override
	public Restaurant updateRestaurant(Restaurant res,String key) throws RestaurantException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new RestaurantException("Please provide valid key");
			
		}
		
		if(res.getRestaurantId()==loggedInUser.getUserId()) {
			
			return restaurantDao.save(res);
			
		}else {
				
				throw new RestaurantException("Invalid Restaurant Details");
		}
	}

	@Override
	public String removeRestaurant(Integer id, String key) throws RestaurantException {
		
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		Optional<Restaurant> opt = restaurantDao.findById(id);
		
		if(opt.isPresent()) {
			Restaurant res = opt.get();
			if(res.getRestaurantId()==loggedInUser.getUserId()) {
				restaurantDao.delete(res);
				return "Account removed Successfully";
			}else {
				throw new RestaurantException("Invalid Restaurant Details");
			}
			
		}else {
			throw new RestaurantException("No Restaurant Found");
		}
		
	}

	@Override
	public Restaurant viewRestaurant(String key) throws RestaurantException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);

		Optional<Restaurant> opt = restaurantDao.findById(loggedInUser.getUserId());
		
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new RestaurantException("Invalid Details");
			
			
		}
	}

	@Override
	public List<Restaurant> viewNearByRestaurant(String location) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> viewRestaurantByItemNAme(String name) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> getAllRestaurants() throws RestaurantException {
		
		
		return restaurantDao.findAll();
	}

	@Override
	public List<Restaurant> getAllRestaurantsOrderByRating() throws RestaurantException {
		
		return restaurantDao.findByOrderByRatingDesc();
	}

	@Override
	public List<Restaurant> getAllRestaurantsOrderByDeliveryTime() throws RestaurantException {
		// TODO Auto-generated method stub
		return restaurantDao.findByOrderByDeliveryTimeDesc();
	}

	@Override
	public List<Restaurant> getAllRestaurantsOrderByDiscount() throws RestaurantException {
		// TODO Auto-generated method stub
		return restaurantDao.findByOrderByDiscountDesc();
	}

}
