package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
@CrossOrigin(origins = "*")
public class ItemController {
	
	@Autowired
	private IItemService iItemService;
	
	
	@PostMapping("/item")
	public  ResponseEntity<Item> addItemHandler(@RequestParam Integer catId,@RequestParam String itemName,@RequestParam Double cost, @RequestParam String thumbnail, @RequestParam(required = false) String key ) throws CustomerException, FoodCartException, ItemException, RestaurantException {
		
		
		
		Item res_item = iItemService.addItem(catId,itemName,cost,thumbnail,key);
		
		
		return new ResponseEntity<Item>(res_item,HttpStatus.OK);
		
	}
	
	@PutMapping("/item")
	public  ResponseEntity<Item> updateItemHandler(@RequestParam Integer itemId, @RequestParam(required = false) String itemName,@RequestParam(required = false) Double cost,@RequestParam(required = false) Integer catId,@RequestParam(required = false) String thumbnail, @RequestParam(required = false) String key ) throws CustomerException, FoodCartException, ItemException, RestaurantException {
		
		
		
		Item res_item = iItemService.updateItem(itemId,itemName,cost,catId,thumbnail,key);
		
		
		return new ResponseEntity<Item>(res_item,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/item")
	public  ResponseEntity<String> removeItemHandler(@RequestParam Integer resId, @RequestParam Integer catId,@RequestParam Integer itemId, @RequestParam(required = false) String key ) throws CustomerException, FoodCartException, ItemException, RestaurantException {
		
		
		
		String res_item = iItemService.removeItem(resId,catId,itemId, key);
		
		
		return new ResponseEntity<String>(res_item,HttpStatus.OK);
		
	}
	@GetMapping("/item")
	public  ResponseEntity<Item> viewItemHandler(@RequestParam Integer itemid, @RequestParam(required = false) String key ) throws CustomerException, FoodCartException, ItemException, RestaurantException {
		
		
		
		Item res_item = iItemService.viewItem(itemid, key);
		
		
		return new ResponseEntity<Item>(res_item,HttpStatus.OK);
		
	}
	@GetMapping("/allitem")
	public  ResponseEntity<List<Item>> viewAllItemHandler(@RequestParam Integer resId, @RequestParam(required = false) String key ) throws CustomerException, FoodCartException, ItemException, RestaurantException {
		
		
		
		List<Item> res_item = iItemService.viewAllItems(resId, key);
		
		
		return new ResponseEntity<List<Item>>(res_item,HttpStatus.OK);
		
	}
	
	@GetMapping("/allitemInCategory")
	public  ResponseEntity<List<Item>> viewAllItemsInCategoryHandler(@RequestParam Integer catId, @RequestParam(required = false) String key ) throws CustomerException, FoodCartException, ItemException, RestaurantException {
		
		
		
		List<Item> res_item = iItemService.viewAllItemsInCategory(catId, key);
		
		
		return new ResponseEntity<List<Item>>(res_item,HttpStatus.OK);
		
	}
}
