package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.RestaurantException;
import com.masai.model.Restaurant;
import com.masai.service.iRestaurantService.IRestaurantService;

@RestController
@CrossOrigin(origins = "*")
public class RestaurantController {
	
	@Autowired
	private IRestaurantService iRestaurantService;
	
	@PostMapping("/restaurant")
	
	public ResponseEntity<Restaurant> addRestaurantHandler(@RequestBody Restaurant res) throws RestaurantException, CustomerException{
		
		Restaurant addedRestaurant = iRestaurantService.addRestaurant(res);
		
		return new ResponseEntity<Restaurant>(addedRestaurant,HttpStatus.CREATED);
	}
	
	@PutMapping("/restaurant")
	public ResponseEntity<Restaurant> updateRestaurantHandler(@RequestBody Restaurant res, @RequestParam(required = false) String key) throws RestaurantException, CustomerException{
		
		Restaurant updatedRestaurant = iRestaurantService.updateRestaurant(res, key);
		
		return new ResponseEntity<Restaurant>(updatedRestaurant,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/restaurant")
	public ResponseEntity<String> deleteRestaurantHandler(@RequestParam Integer id, @RequestParam(required = false) String key) throws RestaurantException, CustomerException{
		
		String deletedRestaurant = iRestaurantService.removeRestaurant(id, key);
		
		return new ResponseEntity<String>(deletedRestaurant,HttpStatus.CREATED);
	}
	
	@GetMapping("/restaurant")
	public ResponseEntity<Restaurant> viewRestaurantHandler(@RequestParam(required = false) String key) throws RestaurantException, CustomerException{
		
		Restaurant viewedRestaurant = iRestaurantService.viewRestaurant(key);
		
		return new ResponseEntity<Restaurant>(viewedRestaurant,HttpStatus.CREATED);
	}
	
	@GetMapping("/restaurants")
	public ResponseEntity<List<Restaurant>> getAllRestaurantsHandler() throws RestaurantException, CustomerException{
		
		List<Restaurant> restaurants = iRestaurantService.getAllRestaurants();
		
		return new ResponseEntity<List<Restaurant>>(restaurants,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllRestaurantsOrderByRating")
	public ResponseEntity<List<Restaurant>> getAllRestaurantsOrderByRatingHandler() throws RestaurantException, CustomerException{
		
		List<Restaurant> restaurants = iRestaurantService.getAllRestaurantsOrderByRating();
		
		return new ResponseEntity<List<Restaurant>>(restaurants,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getAllRestaurantsOrderByDeliveryTime")
	public ResponseEntity<List<Restaurant>> getAllRestaurantsOrderByDeliveryTimeHandler() throws RestaurantException, CustomerException{
		
		List<Restaurant> restaurants = iRestaurantService.getAllRestaurantsOrderByDeliveryTime();
		
		return new ResponseEntity<List<Restaurant>>(restaurants,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllRestaurantsOrderByDiscount")
	public ResponseEntity<List<Restaurant>> getAllRestaurantsOrderByDiscountHandler() throws RestaurantException, CustomerException{
		
		List<Restaurant> restaurants = iRestaurantService.getAllRestaurantsOrderByDiscount();
		
		return new ResponseEntity<List<Restaurant>>(restaurants,HttpStatus.CREATED);
	}
	
	
	
	
	

}
