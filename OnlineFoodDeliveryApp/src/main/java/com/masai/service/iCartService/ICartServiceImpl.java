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
			item.getCarts().add(cart);			
		
			
			
			return foodCartDao.save(cart);
			
		}else {
			
			FoodCart cart = opt.get().getCart();
			cart.getItemList().add(item);
			item.getCarts().add(cart);
			return foodCartDao.save(cart);
		}

		
	}

	@Override
	public FoodCart increaseQuantity(Item item, Integer quantity,String key)throws FoodCartException, ItemException, CustomerException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new CustomerException("Please provide valid key");
		}
		
		Optional<Customer> opt = customerDao.findById(loggedInUser.getUserId());
		
		
		if(opt.get().getCart() == null) {
			
			throw new FoodCartException("Your Cart is Empty");
			
		}else {
			
			FoodCart cart = opt.get().getCart();
			
			if(cart.getItemList().contains(item)) {
				
				for(Item cart_item : cart.getItemList()) {
					
					if(cart_item == item) {
						
						if(cart_item.getQuantity()>0) {
							cart_item.setQuantity(cart_item.getQuantity()+1);
							cart_item.getCarts().add(cart);
							return foodCartDao.save(cart);
						}else if(cart_item.getQuantity()==0) {
							cart.getItemList().add(cart_item);
							cart_item.getCarts().add(cart);
							return foodCartDao.save(cart);
						}
						
						
					}
					
				}
				
			}
			
				throw new ItemException("No Item Found");
			
			
		}

		
	}





	@Override
	public FoodCart reduceQuantity(Item item, Integer quantity,String key)throws FoodCartException, ItemException, CustomerException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new CustomerException("Please provide valid key");
		}
		
		Optional<Customer> opt = customerDao.findById(loggedInUser.getUserId());
		
		
		if(opt.get().getCart() == null) {
			
			throw new FoodCartException("Your Cart is Empty");
			
		}else {
			
			FoodCart cart = opt.get().getCart();
			
			if(cart.getItemList().contains(item)) {
				
				for(Item cart_item : cart.getItemList()) {
					
					if(cart_item == item) {
						
						if(cart_item.getQuantity()>1) {
							
							cart_item.setQuantity(cart_item.getQuantity()-1);
							cart_item.getCarts().add(cart);
							return foodCartDao.save(cart);
							
						}else if(cart_item.getQuantity()==1) {
							
							cart.getItemList().remove(cart_item);
							cart_item.getCarts().add(cart);
							return foodCartDao.save(cart);
						}
					
					}

				}
				
			}
			
				throw new ItemException("No Item Found");
			
			
		}

		
	}



	@Override
	public FoodCart removeItem(Item item,String key) throws FoodCartException, ItemException {

		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new CustomerException("Please provide valid key");
		}
		
		Optional<Customer> opt = customerDao.findById(loggedInUser.getUserId());
		
		if(opt.get().getCart() == null) {
			
			throw new FoodCartException("Your Cart is Empty");
			
		}else {
			
			FoodCart cart = opt.get().getCart();
			
			if(cart.getItemList().contains(item)) {
				
				cart.getItemList().remove(item);
				item.getCarts().remove(cart);
				
				return foodCartDao.save(cart);
				
			}
			
			throw new ItemException("Item Does Not Exist");
			
		}
		
		
	}

	@Override
	public FoodCart clearCart(String key) throws FoodCartException, CustomerException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new CustomerException("Please provide valid key");
		}
		
		Optional<Customer> opt = customerDao.findById(loggedInUser.getUserId());
		
		if(opt.get().getCart() == null) {
			
			throw new FoodCartException("Your Cart is Empty");
			
		}else {
			
			FoodCart cart = opt.get().getCart();
			
			for(Item item : cart.getItemList()) {
				item.getCarts().remove(cart);
			}
			
			cart.getItemList().clear();
			
			return foodCartDao.save(cart);
			
		}
		
	}

}
