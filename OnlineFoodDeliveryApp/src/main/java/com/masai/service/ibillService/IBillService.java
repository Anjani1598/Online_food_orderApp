package com.masai.service.ibillService;

import java.util.List;

import com.masai.exceptions.CustomerException;
import com.masai.model.Bill;
import com.masai.model.OrderDetails;

public interface IBillService {
	
	public Bill addBill(String key) throws CustomerException;

	public Bill updateBill(Bill bill, String key) throws CustomerException;
	
	public Bill getBillfromOrder(Integer orderId, String key)throws CustomerException;

	public List<Bill> getBillFromCart(String key)throws CustomerException;
}
