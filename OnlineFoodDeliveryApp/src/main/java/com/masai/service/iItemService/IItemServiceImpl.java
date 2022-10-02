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

	@Override
	public Item addItem(Item item , String key) throws RestaurantException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new RestaurantException("Please provide valid key");
			
		}
		
		Optional<Restaurant> opt = restaurantDao.findById(loggedInUser.getUserId());
		
		if(opt.isPresent()) {
			
			Restaurant res = opt.get();
			
			for(Category cat : res.getCategories()) {
				if(cat.getCategoryName() == item.getCategory().getCategoryName()) {
					cat.getItems().add(item);
					item.setCategory(cat);
					itemDao.save(item);
					break;
				}
			}
			item.setRestaurant(res);
			
			
			return itemDao.save(item);


		
		}else {
			
			throw new RestaurantException("please login first and add restaurant details");

			
			
			
		}
		


	}

	@Override
	public Item updateItem(Item item, String key) throws RestaurantException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new RestaurantException("Please provide valid key");
			
		}
		
		Optional<Restaurant> opt = restaurantDao.findById(loggedInUser.getUserId());
		
		if(opt.isPresent()) {
			
			Restaurant res = opt.get();
			
			
			if(res.getItems().contains(item)) {
				
				for(Item res_item : res.getItems()) {
					if(res_item.getItemId() == item.getItemId()) {
						
						res.getItems().remove(res_item);
//						res_item.setCategory(item.getCategory());
//						res_item.setCost(item.getCost());
//						res_item.setItemName(item.getItemName());
						res.getItems().add(item);
						
						res_item.setRestaurant(res);
						
						return itemDao.save(item);
	
						
					}
				}
			}else {
				throw new RestaurantException("No items found");
			}
	
		}
			
			throw new RestaurantException("please login first and add restaurant details");

	
		
	}

	@Override
	public Item viewItem(Item item, String key) throws RestaurantException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new RestaurantException("Please provide valid key");
			
		}
		
		Optional<Restaurant> opt = restaurantDao.findById(loggedInUser.getUserId());
		
		if(opt.isPresent()) {
			
			Restaurant res = opt.get();
			
			if(res.getItems().contains(item)) {
				return item;
			}else {
				throw new RestaurantException("Item not Found");
			}
			
		}
		
		throw new RestaurantException("please login first and add restaurant details");

			
			
		
	}

	@Override
	public Item removeItem(Item item, String key) throws RestaurantException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new RestaurantException("Please provide valid key");
			
		}
		
		Optional<Restaurant> opt = restaurantDao.findById(loggedInUser.getUserId());
		
		if(opt.isPresent()) {
			
			Restaurant res = opt.get();
			
			if(res.getItems().contains(item)) {
				
				res.getItems().remove(item);
				
				item.setRestaurant(null);
				return item;
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
