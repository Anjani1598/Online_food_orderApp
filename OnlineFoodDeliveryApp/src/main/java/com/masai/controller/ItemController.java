package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	public  ResponseEntity<Item> addItemHandler(@RequestParam Integer catId,@RequestParam String itemName,@RequestParam Double cost, @RequestParam(required = false) String key ) throws CustomerException, FoodCartException, ItemException, RestaurantException {
		
		
		
		Item res_item = iItemService.addItem(catId,itemName,cost,key);
		
		
		return new ResponseEntity<Item>(res_item,HttpStatus.OK);
		
	}
	
	@PutMapping("/item")
	public  ResponseEntity<Item> updateItemHandler(@RequestParam Integer itemId, @RequestParam String itemName,@RequestParam Double cost,@RequestParam Integer catId, @RequestParam(required = false) String key ) throws CustomerException, FoodCartException, ItemException, RestaurantException {
		
		
		
		Item res_item = iItemService.updateItem(itemId,itemName,cost,catId, key);
		
		
		return new ResponseEntity<Item>(res_item,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/item")
	public  ResponseEntity<String> removeItemHandler(@RequestParam Integer itemId, @RequestParam(required = false) String key ) throws CustomerException, FoodCartException, ItemException, RestaurantException {
		
		
		
		String res_item = iItemService.removeItem(itemId, key);
		
		
		return new ResponseEntity<String>(res_item,HttpStatus.OK);
		
	}
	@GetMapping("/item")
	public  ResponseEntity<Item> viewItemHandler(@RequestParam Integer itemid, @RequestParam(required = false) String key ) throws CustomerException, FoodCartException, ItemException, RestaurantException {
		
		
		
		Item res_item = iItemService.viewItem(itemid, key);
		
		
		return new ResponseEntity<Item>(res_item,HttpStatus.OK);
		
	}
}
