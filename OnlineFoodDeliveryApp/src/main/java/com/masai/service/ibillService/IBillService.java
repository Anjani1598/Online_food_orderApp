package com.masai.service.ibillService;

import com.masai.exceptions.CustomerException;
import com.masai.model.Bill;

public interface IBillService {
	
	public Bill addBill(String key) throws CustomerException;

}
