package com.masai.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
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
import com.masai.model.Category;
import com.masai.model.Customer;
import com.masai.service.iCategoryService.ICategoryService;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {
	
	
	@Autowired
	private ICategoryService iCategoryService;
	
	
	@PostMapping("/category")
	public ResponseEntity<Category> addCategoryHandler(@RequestParam String categoryName,@RequestParam(required =  false) String key) throws CustomerException, RestaurantException{
		
		
		Category category =  iCategoryService.addCategory(categoryName, key);
		return new ResponseEntity<Category>(category,HttpStatus.CREATED);
	}
	
	@PutMapping("/category")
	public ResponseEntity<Category> updateCategoryHandler(@RequestParam Integer catId, @RequestParam String catName,@RequestParam(required =  false) String key) throws CustomerException, RestaurantException{
		
		
		Category category =  iCategoryService.updateCategory(catId,catName, key);
		return new ResponseEntity<Category>(category,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/category")
	public ResponseEntity<String> removeCategoryHandler(@RequestParam Integer resId, @RequestParam Integer catId, @RequestParam(required =  false) String key) throws CustomerException, RestaurantException{
		
		
		String category =  iCategoryService.removeCategory(resId,catId, key);
		return new ResponseEntity<String>(category,HttpStatus.CREATED);
	}
	
	@GetMapping("/allCategories")
	public ResponseEntity<List<Category>> viewAllCategoryHandler(@RequestParam Integer restaurantId, @RequestParam String key) throws RestaurantException{
		
		
		List<Category> cats = iCategoryService.viewAllCategory(restaurantId, key);
		
		return new ResponseEntity<List<Category>>(cats,HttpStatus.OK);
	}
	
	
	
	
	

}
