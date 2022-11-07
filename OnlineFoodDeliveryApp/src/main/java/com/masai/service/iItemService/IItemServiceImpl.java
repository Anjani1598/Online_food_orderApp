package com.masai.service.iItemService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.RestaurantException;
import com.masai.model.Category;
import com.masai.model.CurrentUserSession;
import com.masai.model.CustomerItem;
import com.masai.model.FoodCart;
import com.masai.model.Item;
import com.masai.model.Restaurant;
import com.masai.repositories.CategoryDao;
import com.masai.repositories.CustomerItemDao;
import com.masai.repositories.FoodCartDao;
import com.masai.repositories.ItemDao;
import com.masai.repositories.RestaurantDao;
import com.masai.repositories.SessionDao;

@Service
public class IItemServiceImpl implements IItemService {
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Autowired
	private SessionDao sessionDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private CustomerItemDao customerItemDao;
	
	@Autowired
	private FoodCartDao foodCartDao;

	@Override
	public Item addItem(Integer catId,String itemName,Double cost,String thumbnail, String key) throws RestaurantException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new RestaurantException("Please provide valid key");
			
		}
		
		Optional<Restaurant> opt = restaurantDao.findById(loggedInUser.getUserId());
		
		if(opt.isPresent()) {
			
			Restaurant res = opt.get();
			
			for(Category cat : res.getCategories()) {
				
				
					
//				for(Item items : cat.getItems()) {
//					if(items.getItemName().equals(item.getItemName())) {
//						throw new RestaurantException("Item already Exists");
//					}
//				}
					
				
				
				
				
				if(cat.getCatId() == catId) {
					
					Item item =  new Item();
					item.setItemName(itemName);
					item.setCategory(cat);
					item.setCost(cost);
					item.setItemThumbnail(thumbnail);
					item.setRestaurant(res);
					item.setCategory(cat);
					res.getItems().add(item);
					cat.getItems().add(item);
					
					
					return itemDao.save(item);
					
				}
			}
			throw new RestaurantException("Category not found");


		
		}else {
			
			throw new RestaurantException("please login first and add restaurant details");

			
		}
	}

	@Override
	public Item updateItem(Integer itemId, String itemName,Double cost,Integer catId,String thumbnail, String key) throws RestaurantException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new RestaurantException("Please provide valid key");
			
		}
		
		Optional<Restaurant> opt = restaurantDao.findById(loggedInUser.getUserId());
		Item item = itemDao.findById(itemId).get();
		
		if(opt.isPresent()) {
			
			Restaurant res = opt.get();
			
			
			if(res.getItems().contains(item)) {
				
				item.setItemName(itemName);
				item.setCategory(categoryDao.findById(catId).get());
				item.setCost(cost);
				item.setItemThumbnail(thumbnail);
				
				return itemDao.save(item);
				
	
			}else {
				throw new RestaurantException("No items found");
			}
	
		}
			
			throw new RestaurantException("please login first and add restaurant details");

	
		
	}

	@Override
	public Item viewItem(Integer itemid, String key) throws RestaurantException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new RestaurantException("Please provide valid key");
			
		}
		
		Optional<Restaurant> opt = restaurantDao.findById(loggedInUser.getUserId());
		
		if(opt.isPresent()) {
			
			Restaurant res = opt.get();
			
			if(res.getItems().contains(itemDao.findById(itemid).get())) {
				return itemDao.findById(itemid).get();
			}else {
				throw new RestaurantException("Item not Found");
			}
			
		}
		
		throw new RestaurantException("please login first and add restaurant details");

			
			
		
	}

	@Override
	public String removeItem(Integer resId, Integer catId, Integer itemId, String key) throws RestaurantException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new RestaurantException("Please provide valid key");
			
		}
		
		if(loggedInUser.getUserId()==resId) {
			Restaurant res = restaurantDao.findById(resId).get();
			Category cat = categoryDao.findById(catId).get();
			if(res!=null) {
				if(cat!=null) {
					
					
					Item item = itemDao.findById(itemId).get();
					
					if(item!=null) {
						
						List<CustomerItem> customerItems = customerItemDao.findByItem(item);
						
						System.out.println("hai iam in remove item1");
						res.getItems().remove(item);
						cat.getItems().remove(item);
						
						
						
						for(CustomerItem custItem : customerItems) {
							custItem.setCart(null);
							custItem.setItem(null);
						
						}
						
						item.getCustomerItems().removeAll(customerItems);

						item.setCategory(null);
						item.setRestaurant(null);
						itemDao.delete(item);
						return "Item Removed Successfully";

					}
					
					throw new RestaurantException("Invalid Item Details");

				
				}
				throw new RestaurantException("Invalid Category Details");

			}
			throw new RestaurantException("Invalid Restaurant Details");

		}
		
		throw new RestaurantException("Invalid Restaurant Details");

		
			
			
		
	}

	@Override
	public List<Item> viewAllItemsInCategory(Integer catId, String key) throws RestaurantException {
		
		
		Optional<Category> opt = categoryDao.findById(catId);
		
		if(opt.isPresent()) {
			return itemDao.findByCategory(opt.get());
		}
		throw new RestaurantException("No Category Found");
	}

	@Override
	public List<Item> viewAllItems(Integer resId, String key)throws RestaurantException {
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new RestaurantException("Please provide valid key");
			
		}
		
		if(loggedInUser.getUserId()==resId) {
			Optional<Restaurant> opt = restaurantDao.findById(resId);
			
			if(opt.isPresent()) {
				
				return new ArrayList<>(opt.get().getItems());
				
			}
			throw new RestaurantException("Invalid Details");
			
		}
		
		throw new RestaurantException("invalid restaurant details");
		
	}

	@Override
	public List<Item> viewAllItemsByName(String name, String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
