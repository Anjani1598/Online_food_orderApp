package com.masai.service.iRestaurantService;

import java.util.List;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.RestaurantException;
import com.masai.model.Restaurant;

public interface IRestaurantService {
	
	
	public Restaurant addRestaurant(Restaurant res) throws RestaurantException, CustomerException;
	
	
	public Restaurant updateRestaurant(Restaurant res, String key) throws RestaurantException;

	
	public String removeRestaurant(Integer id, String key) throws RestaurantException;

	
	public Restaurant viewRestaurant(String key) throws RestaurantException;
	
	
	public List<Restaurant> viewNearByRestaurant(String location) throws RestaurantException;

	
	public List<Restaurant> viewRestaurantByItemNAme(String name) throws RestaurantException;

	
	public List<Restaurant> getAllRestaurants()throws RestaurantException;
	
	
	public List<Restaurant> getAllRestaurantsOrderByRating()throws RestaurantException;
	
	public List<Restaurant> getAllRestaurantsOrderByDeliveryTime()throws RestaurantException;
	
	public List<Restaurant> getAllRestaurantsOrderByDiscount()throws RestaurantException;

}

