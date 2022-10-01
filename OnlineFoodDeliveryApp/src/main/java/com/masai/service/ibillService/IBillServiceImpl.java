package com.masai.service.ibillService;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.model.Bill;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.Item;
import com.masai.repositories.BillDao;
import com.masai.repositories.CustomerDao;
import com.masai.repositories.SessionDao;


@Service
public class IBillServiceImpl implements IBillService {
	
	@Autowired
	private SessionDao sessionDao;
	
	@Autowired
	private BillDao billDao;
	@Autowired
	private CustomerDao customerDao;
	@Override
	public Bill addBill(String key) throws CustomerException {
		
		Bill bill = new Bill();
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new CustomerException("Please provide valid key");
		}
		
		bill.setBillDate(LocalDateTime.now());
		
		Optional<Customer> opt = customerDao.findById(loggedInUser.getUserId());
		
		bill.setTotalItem(opt.get().getCart().getItemList().size());
		
		Double totalCost = (double) 0;
		for(Item items : opt.get().getCart().getItemList()) {
			totalCost += items.getCost()*items.getQuantity();
		}
		bill.setTotalCost(totalCost);
		return billDao.save(bill);
	
	}

}
