package com.masai.service.iOrderService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.RestaurantException;
import com.masai.model.Bill;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.OrderDetails;
import com.masai.model.Restaurant;
import com.masai.repositories.BillDao;
import com.masai.repositories.CustomerDao;
import com.masai.repositories.OrderDetailsDao;
import com.masai.repositories.RestaurantDao;
import com.masai.repositories.SessionDao;
import com.masai.service.ibillService.IBillService;

@Service
public class IOrderServiceImpl implements IOrderService {
	
	@Autowired
	private OrderDetailsDao orderDao;
	@Autowired
	private SessionDao sessionDao;
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Autowired
	private IBillService iBillService;

	@Override
	public OrderDetails addOrder(String key) throws CustomerException {
		
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new CustomerException("Please provide valid key");
		}
		
		
		
		Optional<Customer> opt = customerDao.findById(loggedInUser.getUserId());
		
		
			OrderDetails order = new OrderDetails();
			
			order.setOrderDate(LocalDateTime.now());
			order.setOrderStatus("Pending");
			
			
			order.setBill(iBillService.addBill(key));
		
		if(opt.get().getCart().getOrder().contains(order)==false) {
				return orderDao.save(order);
			}else {
				throw new CustomerException("orderr exists");
			}


		
		
	}

	@Override
	public List<OrderDetails> getAllOrderDetails(String key) throws CustomerException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new CustomerException("Please provide valid key");
		}
		
		Optional<Restaurant> opt = restaurantDao.findById(loggedInUser.getUserId());
		
		if(opt.isPresent()) {
			
			return orderDao.findByRestaurantRestaurantId(opt.get().getRestaurantId());
		}
		throw new CustomerException("invalid details");
		
		
	}

	@Override
	public String updateOrder(Integer id, String key) throws CustomerException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new CustomerException("Please provide valid key");
		}
		
		Optional<OrderDetails> opt = orderDao.findById(id);
		if(opt.isPresent()) {
			OrderDetails order = opt.get();
			
			order.setOrderStatus("Accepted");
			order.setOrderState(true);
			
			orderDao.save(order);
			
			return "done";
		}
		
		throw new CustomerException("invalid details");
		
	}

	@Override
	public String removeOrder(Integer id, String key) throws CustomerException {
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);	
		
		if(loggedInUser==null) {
			throw new CustomerException("Please provide valid key");
			
		}
		Optional<OrderDetails> opt = orderDao.findById(id);
		if(opt.isPresent()) {
			OrderDetails order = opt.get();
			
			order.setHide(true);
			
			orderDao.save(order);
			
			return "done";
		}
		
		throw new CustomerException("invalid details");
	}

	@Override
	public Customer fetchCustomerDetails(Integer orderId, String key) throws CustomerException {
		
	}

	@Override
	public List<OrderDetails> fetchCustomerOrders(String key) throws CustomerException {

		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new CustomerException("Please provide valid key");
		}
		Optional<Customer> opt = customerDao.findById(loggedInUser.getUserId());
		
		List<Bill> bills =  iBillService.getBillFromCart(key);
		List<OrderDetails> orders = new ArrayList<>();
		for(Bill bill : bills) {
			
			orders.add(orderDao.findByBill(bill));
			
		}
		
		if(orders.size()>0) {
			return orders;
		}
		throw new CustomerException("No orders found");
		
		
		
	}
	
	
	

}
