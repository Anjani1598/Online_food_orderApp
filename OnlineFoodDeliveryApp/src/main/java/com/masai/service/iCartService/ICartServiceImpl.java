package com.masai.service.iCartService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.FoodCartException;
import com.masai.exceptions.ItemException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.FoodCart;
import com.masai.model.Item;
import com.masai.repositories.CustomerDao;
import com.masai.repositories.FoodCartDao;
import com.masai.repositories.SessionDao;

@Service
public class ICartServiceImpl implements ICartService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private FoodCartDao foodCartDao;
	
	@Autowired
	private SessionDao sessionDao;

	@Override
	public FoodCart addItemToCart(Item item,String key) throws FoodCartException, ItemException, CustomerException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new CustomerException("Please provide valid key");
		}
		
		
		Optional<Customer> opt = customerDao.findById(loggedInUser.getUserId());
		
		if(opt.get().getCart() == null) {
			
			FoodCart cart = new FoodCart();
			
			cart.setCustomer(opt.get());
			opt.get().setCart(cart);
			
			
			
			cart.getItemList().add(item);
			item.setCart(cart);
			
		
			
			
			return foodCartDao.save(cart);
			
		}else {
			
			FoodCart cart = opt.get().getCart();
			cart.getItemList().add(item);
			item.setCart(cart);
			return foodCartDao.save(cart);
		}

		
	}

	@Override
	public FoodCart increaseQuantity(FoodCart cart, Item item, Integer quantity)
			throws FoodCartException, ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart reduceQuantity(FoodCart cart, Item item, Integer quantity) throws FoodCartException, ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart removeItem(FoodCart cart, Item item) throws FoodCartException, ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart clearCart(FoodCart cart) throws FoodCartException {
		// TODO Auto-generated method stub
		return null;
	}

}
