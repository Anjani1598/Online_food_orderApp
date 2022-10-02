package com.masai.service.iOrderService;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.OrderDetails;
import com.masai.repositories.BillDao;
import com.masai.repositories.CustomerDao;
import com.masai.repositories.OrderDetailsDao;
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
			order.setCart(opt.get().getCart());
			order.setOrderStatus("Pending");
			
			
			order.setBill(iBillService.addBill(key));
		
		x	if(opt.get().getCart().getOrder().contains(order)==false) {
				return orderDao.save(order);
			}else {
				throw new CustomerException("orderr exists");
			}


		
		
	}
	

}
