package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.RestaurantException;
import com.masai.model.Restaurant;
import com.masai.service.iRestaurantService.IRestaurantService;

@RestController
public class RestaurantController {
	
	@Autowired
	private IRestaurantService iRestaurantService;
	
	@PostMapping("/restaurant")
	public ResponseEntity<Restaurant> addRestaurantHandler(@RequestBody Restaurant res) throws RestaurantException, CustomerException{
		
		Restaurant addedAdmin = iRestaurantService.addRestaurant(res);
		
		return new ResponseEntity<Restaurant>(addedAdmin,HttpStatus.CREATED);
	}
	
	

}
