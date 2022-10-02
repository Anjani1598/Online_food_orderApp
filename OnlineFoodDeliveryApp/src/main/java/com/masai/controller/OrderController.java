package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.FoodCartException;
import com.masai.exceptions.ItemException;
import com.masai.model.FoodCart;
import com.masai.model.OrderDetails;
import com.masai.service.iOrderService.IOrderService;

@RestController
public class OrderController {
	
	
	@Autowired
	private IOrderService iOrderService;
	
	
	@PostMapping("/order")
	public  ResponseEntity<OrderDetails> addOrderHandler(@RequestParam(required = false) String key ) throws CustomerException, FoodCartException, ItemException {
		
		
				
		OrderDetails order = iOrderService.addOrder(key);
		
		return new ResponseEntity<OrderDetails>(order,HttpStatus.OK);
		
	}
	
	
	

}
