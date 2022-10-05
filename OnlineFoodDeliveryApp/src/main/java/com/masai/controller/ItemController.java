package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.FoodCartException;
import com.masai.exceptions.ItemException;
import com.masai.exceptions.RestaurantException;
import com.masai.model.Item;
import com.masai.service.iItemService.IItemService;

@RestController
public class ItemController {
	
	@Autowired
	private IItemService iItemService;
	
	
	@PostMapping("/item")
	public  ResponseEntity<Item> addItemHandler(@RequestBody Item item, @RequestParam(required = false) String key ) throws CustomerException, FoodCartException, ItemException, RestaurantException {
		
		
		
		Item res_item = iItemService.addItem(item, key);
		
		
		return new ResponseEntity<Item>(res_item,HttpStatus.OK);
		
	}
}
