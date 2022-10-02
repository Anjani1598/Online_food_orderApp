package com.masai.service.iRestaurantService;

import java.util.List;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.RestaurantException;
import com.masai.model.Restaurant;

public interface IRestaurantService {
	
	
	public Restaurant addRestaurant(Restaurant res) throws RestaurantException, CustomerException;
	
	
	public Restaurant updateRestaurant(Restaurant res, String key) throws RestaurantException;

	
	public Restaurant removeRestaurant(Restaurant res, String key) throws RestaurantException;

	
	public Restaurant viewRestaurant(Restaurant res, String key) throws RestaurantException;
	
	
	public List<Restaurant> viewNearByRestaurant(String location) throws RestaurantException;

	
	public List<Restaurant> viewRestaurantByItemNAme(String name) throws RestaurantException;


}
