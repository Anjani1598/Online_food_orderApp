package com.masai.service.iOrderService;

import java.util.List;

import com.masai.exceptions.CustomerException;
import com.masai.model.Customer;
import com.masai.model.OrderDetails;

public interface IOrderService {
	
	public OrderDetails addOrder(String key) throws CustomerException;
	
	public List<OrderDetails> getAllOrderDetails(String key) throws CustomerException;
	
	public String updateOrder(Integer id, String key) throws CustomerException;
	
	public String removeOrder(Integer Id, String key) throws CustomerException;
	
	public Customer fetchCustomerDetails(Integer orderId, String key)throws CustomerException;
	
	public List<OrderDetails> fetchCustomerOrders(String key)throws CustomerException;
}
