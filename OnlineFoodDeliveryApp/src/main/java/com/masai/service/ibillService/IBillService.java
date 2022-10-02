package com.masai.service.ibillService;

import com.masai.exceptions.CustomerException;
import com.masai.model.Bill;

public interface IBillService {
	
	public Bill addBill(String key) throws CustomerException;

	public Bill updateBill(Bill bill, String key) throws CustomerException;

}
