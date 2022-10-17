package com.masai.service.ibillService;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.RestaurantException;
import com.masai.model.Bill;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.CustomerItem;
import com.masai.model.Item;
import com.masai.model.OrderDetails;
import com.masai.model.Restaurant;
import com.masai.repositories.BillDao;
import com.masai.repositories.CustomerDao;
import com.masai.repositories.RestaurantDao;
import com.masai.repositories.SessionDao;


@Service
public class IBillServiceImpl implements IBillService {
	
	@Autowired
	private SessionDao sessionDao;
	@Autowired
	private BillDao billDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Override
	public Bill addBill(String key) throws CustomerException {
		
		Bill bill = new Bill();
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new CustomerException("Please provide valid key");
		}
		
		
		Optional<Customer> opt = customerDao.findById(loggedInUser.getUserId());
		
		bill.setBillDate(LocalDateTime.now());

		bill.setTotalItem(opt.get().getCart().getCustomerItems().size());
		Restaurant res = null;
		Double totalCost = (double) 0;
		for(CustomerItem items : opt.get().getCart().getCustomerItems()) {
			res = items.getItem().getRestaurant();
			totalCost += items.getItem().getCost()*items.getQuantity();
		}
		bill.setTotalCost(totalCost);
		bill.setCart(opt.get().getCart());
		OrderDetails order = new OrderDetails();
		
		order.setOrderDate(LocalDateTime.now());
		order.setOrderStatus("placed");
		order.setRestaurant(res);
		

		order.setBill(bill);
		bill.setOrder(order);
		res.getOrders().add(order);
//		restaurantDao.save(res);
		
		return billDao.save(bill);
	
	}
	@Override
	public Bill updateBill(Bill bill, String key) throws CustomerException {
		
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new CustomerException("Please provide valid key");
			
		}
		
		Optional<Restaurant> opt = restaurantDao.findById(loggedInUser.getUserId());
		
		bill.getOrder().setOrderStatus("Accepted");
		
		
		
		for(OrderDetails order : opt.get().getOrders()) {
			if(order.getOrderId()==bill.getBillId()) {
				order.setBill(bill);
				return billDao.save(bill);
			}
		}
		throw new CustomerException("no bill found");
		
		
		
	}
	

}
