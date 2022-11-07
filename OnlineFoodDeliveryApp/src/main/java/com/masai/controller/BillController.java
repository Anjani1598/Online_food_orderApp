package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.FoodCartException;
import com.masai.exceptions.ItemException;
import com.masai.model.Bill;
import com.masai.model.FoodCart;
import com.masai.model.Item;
import com.masai.service.ibillService.IBillService;

@RestController
@CrossOrigin(origins = "*")
public class BillController {
	
	@Autowired
	private IBillService iBillService;
	
	@GetMapping("/bill")
	public  ResponseEntity<Bill> addBillHandler(@RequestParam(required = false) String key ) throws CustomerException, FoodCartException, ItemException {
		
		
				
		Bill bill = iBillService.addBill(key);
		
		return new ResponseEntity<Bill>(bill,HttpStatus.OK);
		
	}
	@GetMapping("/billfromOrder")
	public  ResponseEntity<Bill> getBillFromOrderbyHandler(@RequestParam Integer orderId, @RequestParam(required = false) String key ) throws CustomerException, FoodCartException, ItemException {
		
		
				
		Bill bill = iBillService.getBillfromOrder(orderId,key);
		
		return new ResponseEntity<Bill>(bill,HttpStatus.OK);
		
	}
	@GetMapping("/billfromCart")
	public  ResponseEntity<List<Bill>> getBillFromCartbyHandler(@RequestParam(required = false) String key ) throws CustomerException, FoodCartException, ItemException {
		
		
				
		List<Bill> bills = iBillService.getBillFromCart(key);
		
		return new ResponseEntity<List<Bill>>(bills,HttpStatus.OK);
		
	}

}
