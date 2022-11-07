package com.masai.service.iCartService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.FoodCartException;
import com.masai.exceptions.ItemException;
import com.masai.exceptions.RestaurantException;
import com.masai.model.Category;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.CustomerItem;
import com.masai.model.FoodCart;
import com.masai.model.Item;
import com.masai.model.Restaurant;
import com.masai.repositories.CustomerDao;
import com.masai.repositories.CustomerItemDao;
import com.masai.repositories.FoodCartDao;
import com.masai.repositories.ItemDao;
import com.masai.repositories.RestaurantDao;
import com.masai.repositories.SessionDao;

@Service
public class ICartServiceImpl implements ICartService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private FoodCartDao foodCartDao;
	
	@Autowired
	private SessionDao sessionDao;
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private CustomerItemDao customerItemDao;
	

	
	

	@Override
	public FoodCart addItemToCart(Integer itemId,String key) throws FoodCartException, ItemException, CustomerException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new CustomerException("Please provide valid key");
		}
		
		Item item = itemDao.findById(itemId).get();
		Optional<Customer> opt = customerDao.findById(loggedInUser.getUserId());
		Optional<Restaurant> opt_res = restaurantDao.findById(item.getRestaurant().getRestaurantId());
		
		if(opt.get().getCart() == null) {
			
			FoodCart cart = new FoodCart();
			
			cart.setCustomer(opt.get());
			
			opt.get().setCart(cart);
			

			Restaurant res = opt_res.get();
			
			for(Item i : res.getItems()) {
				
				
				System.out.println(i);
				
				if(i.getItemId()==itemId) {
					CustomerItem customerItem = new CustomerItem();
					customerItem.setCart(cart);
					customerItem.setItem(i);
					customerItem.setQuantity(1);
					i.getCustomerItems().add(customerItem);
					cart.getCustomerItems().add(customerItem);
					return foodCartDao.save(cart);
					
				}
			}
			
			throw new FoodCartException("Item does not exist");
			
		
		}else {
			
			FoodCart cart = opt.get().getCart();
			Restaurant res = opt_res.get();
			
			for(Item i : res.getItems()) {
				
				
				
				
				if(i.getItemId()==itemId) {
					
					CustomerItem customerItem = new CustomerItem();
					customerItem.setCart(cart);
					customerItem.setItem(i);
					customerItem.setQuantity(1);
					cart.getCustomerItems().add(customerItem);
					return foodCartDao.save(cart);
					
				}
			}
			throw new FoodCartException("Item does not exist");

		}

		
	}

	@Override
	public FoodCart increaseQuantity(Integer customerItemId,String key)throws FoodCartException, ItemException, CustomerException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new CustomerException("Please provide valid key");
		}
		
		Optional<Customer> opt = customerDao.findById(loggedInUser.getUserId());
		CustomerItem customerItem = customerItemDao.findById(customerItemId).get();
		
		if(opt.get().getCart() == null) {
			
			throw new FoodCartException("Your Cart is Empty");
			
		}else {
			
			FoodCart cart = opt.get().getCart();
			System.out.println("hai");
			if(cart.getCustomerItems().contains(customerItem)) {
				System.out.println("hai");

				customerItem.setQuantity(customerItem.getQuantity()+1);
				
				customerItemDao.save(customerItem);
				return cart;
				
				
				
			}
			
				throw new ItemException("No Item Found");
			
			
		}

		
	}





	@Override
	public FoodCart reduceQuantity(Integer customerItemId, Integer quantity,String key)throws FoodCartException, ItemException, CustomerException {
		
CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new CustomerException("Please provide valid key");
		}
		
		Optional<Customer> opt = customerDao.findById(loggedInUser.getUserId());
		CustomerItem customerItem = customerItemDao.findById(customerItemId).get();
		
		if(opt.get().getCart() == null) {
			
			throw new FoodCartException("Your Cart is Empty");
			
		}else {
			
			FoodCart cart = opt.get().getCart();
			System.out.println("hai");
			if(cart.getCustomerItems().contains(customerItem)) {
				
				customerItem.setQuantity(customerItem.getQuantity()-1);
				customerItemDao.save(customerItem);
				return cart;
				
				
				
			}
			
				throw new ItemException("No Item Found");
			
			
		}

		
		
	}



	@Override
	public FoodCart  removeItem(Integer customerItemId,String key) throws FoodCartException, ItemException {

		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new FoodCartException("Please provide valid key");
		}
		
		Optional<Customer> opt = customerDao.findById(loggedInUser.getUserId());
		CustomerItem customerItem = customerItemDao.findById(customerItemId).get();
		System.out.println("Hi");

		if(opt.get().getCart() == null) {
			
			throw new FoodCartException("Your Cart is Empty");
			
		}else {
			
			FoodCart cart = opt.get().getCart();
			System.out.println("Hi");
			
			if(cart.getCustomerItems().contains(customerItem)) {
				
				Item item = customerItem.getItem();
				
				
				cart.getCustomerItems().remove(customerItem);
				customerItem.setCart(null);
				customerItem.setItem(null);
				item.getCustomerItems().remove(customerItem);
				customerItemDao.delete(customerItem);

				
				return foodCartDao.save(cart);
				
			}
			
			throw new ItemException("Item Does Not Exist");
			
		}
		
		
	}
	@Override
	public FoodCart removeItemAuthorized(Integer itemId) throws FoodCartException, ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart clearCart(String key) throws FoodCartException, CustomerException, ItemException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new CustomerException("Please provide valid key");
		}
		
		Optional<Customer> opt = customerDao.findById(loggedInUser.getUserId());
		
		if(opt.get().getCart() == null) {
			
			throw new FoodCartException("Your Cart is Empty");
			
		}else {
			
			FoodCart cart = opt.get().getCart();
			
			
			System.out.println(cart.getCustomerItems());
			
			for(CustomerItem customerItem : cart.getCustomerItems()) {
					
				removeItem(customerItem.getCustomerItemId(), key);
				
			}

			
			
			
			
			
			return foodCartDao.save(cart);
			
		}
		
	}

	@Override
	public List<CustomerItem> getAllCartItems(String key) throws FoodCartException, CustomerException {
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		

		if(loggedInUser==null) {
			throw new FoodCartException("Please provide valid key");
			
		}
		
		Optional<Customer> opt = customerDao.findById(loggedInUser.getUserId());
		
		if(opt.isPresent()) {
			FoodCart cart = opt.get().getCart();
			
			List<CustomerItem> cartItems = customerItemDao.findByCart(cart);
			
			if(cartItems.size()>0) {
				
				return customerItemDao.findByCart(cart);
				
			}else {
				throw new FoodCartException("Your cart is empty");
			}
			
		}
		
		throw new FoodCartException("invali details");
		
		
			
			
			

		
		

	}

	

}
