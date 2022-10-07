package com.masai.service.iItemService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.RestaurantException;
import com.masai.model.Category;
import com.masai.model.CurrentUserSession;
import com.masai.model.Item;
import com.masai.model.Restaurant;
import com.masai.repositories.CategoryDao;
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

	@Override
	public Item addItem(Integer catId,String itemName,Double cost, String key) throws RestaurantException {
		
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
	public Item updateItem(Integer itemId, String itemName,Double cost,Integer catId, String key) throws RestaurantException {
		
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
				item.setQuantity(1);
				
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
	public String removeItem(Integer itemId, String key) throws RestaurantException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new RestaurantException("Please provide valid key");
			
		}
		
		Optional<Restaurant> opt = restaurantDao.findById(loggedInUser.getUserId());
		Item item = itemDao.findById(itemId).get();
		if(opt.isPresent()) {
			
			Restaurant res = opt.get();
			
			if(res.getItems().contains(item)) {
				
				res.getItems().remove(item);
				Category cat = item.getCategory();
				cat.getItems().remove(item);
				itemDao.delete(item);
				return "Item removed Successfully";
			}else {
				throw new RestaurantException("Item not Found");
			}
			
			
			
			
		}
		throw new RestaurantException("Please login first");
		
	}

	@Override
	public List<Item> viewAllItems(Category category, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> viewAllItems(Restaurant res, String key)throws RestaurantException {
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new RestaurantException("Please provide valid key");
			
		}
		
		if(loggedInUser.getUserId()==res.getRestaurantId()) {
			return new ArrayList<>(res.getItems());
		}
		
		throw new RestaurantException("invalid restaurant details");
		
	}

	@Override
	public List<Item> viewAllItemsByName(String name, String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
