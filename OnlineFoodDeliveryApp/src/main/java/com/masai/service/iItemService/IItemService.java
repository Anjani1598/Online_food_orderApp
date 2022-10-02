package com.masai.service.iItemService;

import java.util.List;

import com.masai.exceptions.RestaurantException;
import com.masai.model.Category;
import com.masai.model.Item;
import com.masai.model.Restaurant;

public interface IItemService {
	
	public Item addItem(Item item,String key) throws RestaurantException;
	
	public Item updateItem(Item item,String key)throws RestaurantException;
	
	public Item viewItem(Item item,String key)throws RestaurantException;
	
	public Item removeItem(Item item,String key)throws RestaurantException;
	
	public List<Item> viewAllItems(Category category,String key)throws RestaurantException;
	
	public List<Item> viewAllItems(Restaurant res,String key)throws RestaurantException;
	
	public List<Item> viewAllItemsByName(String name,String key)throws RestaurantException;



	
	

}
