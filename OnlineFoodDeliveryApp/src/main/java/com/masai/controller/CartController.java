package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.FoodCartException;
import com.masai.exceptions.ItemException;
import com.masai.model.Customer;
import com.masai.model.FoodCart;
import com.masai.model.Item;
import com.masai.service.iCartService.ICartService;

@RestController
public class CartController {
	
	@Autowired
	private ICartService iCartService;
	
	
	@PostMapping("/cart")
	public  ResponseEntity<FoodCart> addItemHandler(@RequestBody Item item, @RequestParam(required = false) String key ) throws CustomerException, FoodCartException, ItemException {
		
		
				
		FoodCart foodCart = iCartService.addItemToCart(item, key);
		
		return new ResponseEntity<FoodCart>(foodCart,HttpStatus.OK);
		
	}
	

}
