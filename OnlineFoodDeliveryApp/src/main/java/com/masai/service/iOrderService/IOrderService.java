package com.masai.service.iOrderService;

import com.masai.exceptions.CustomerException;
import com.masai.model.OrderDetails;

public interface IOrderService {
	
	public OrderDetails addOrder(String key) throws CustomerException;

}
