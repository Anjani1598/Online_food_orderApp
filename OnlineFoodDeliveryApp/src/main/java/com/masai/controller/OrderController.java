package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.FoodCartException;
import com.masai.exceptions.ItemException;
import com.masai.model.FoodCart;
import com.masai.model.OrderDetails;
import com.masai.service.iOrderService.IOrderService;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
	
	
	@Autowired
	private IOrderService iOrderService;
	
	
	@PostMapping("/order")
	public  ResponseEntity<OrderDetails> addOrderHandler(@RequestParam(required = false) String key ) throws CustomerException, FoodCartException, ItemException {
		
		
				
		OrderDetails order = iOrderService.addOrder(key);
		
		return new ResponseEntity<OrderDetails>(order,HttpStatus.OK);
		
	}
	@GetMapping("/order")
	public  ResponseEntity<List<OrderDetails>> getAllOrdersHandler(@RequestParam(required = false) String key ) throws CustomerException, FoodCartException, ItemException {
		
		
				
		List<OrderDetails> orders = iOrderService.getAllOrderDetails(key);
		
		return new ResponseEntity<List<OrderDetails>>(orders,HttpStatus.OK);
		
	}
	@GetMapping("/customerorders")
	public  ResponseEntity<List<OrderDetails>> getAllOrdersfromCustomerHandler(@RequestParam(required = false) String key ) throws CustomerException, FoodCartException, ItemException {
		
		
				
		List<OrderDetails> orders = iOrderService.fetchCustomerOrders(key);
		
		return new ResponseEntity<List<OrderDetails>>(orders,HttpStatus.OK);
		
	}
	
	@PutMapping("/order")
	public  ResponseEntity<String> updateOrderHandler(@RequestParam Integer id,@RequestParam(required = false) String key ) throws CustomerException, FoodCartException, ItemException {
		
		
				
		String orders = iOrderService.updateOrder(id,key);
		
		return new ResponseEntity<String>(orders,HttpStatus.OK);
		
	}
	
	@PutMapping("/hideorder")
	public  ResponseEntity<String> hideOrderHandler(@RequestParam Integer id,@RequestParam(required = false) String key ) throws CustomerException, FoodCartException, ItemException {
		
		
				
		String orders = iOrderService.removeOrder(id,key);
		
		return new ResponseEntity<String>(orders,HttpStatus.OK);
		
	}
	
	
	

}
