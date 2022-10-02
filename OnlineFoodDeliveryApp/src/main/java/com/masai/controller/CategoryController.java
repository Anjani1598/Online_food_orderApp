package com.masai.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.RestaurantException;
import com.masai.model.Category;
import com.masai.model.Customer;
import com.masai.service.iCategoryService.ICategoryService;

@RestController
public class CategoryController {
	
	
	@Autowired
	private ICategoryService iCategoryService;
	
	
	@PostMapping("/category")
	public ResponseEntity<Category> addCustomerHandler(@RequestBody Category cat,@RequestParam(required =  false) String key) throws CustomerException, RestaurantException{
		
		
		Category category =  iCategoryService.addCategory(cat, key);
		return new ResponseEntity<Category>(category,HttpStatus.CREATED);
	}
	
	
	

}
