package com.masai.service.iItemService;

import java.util.List;

import com.masai.exceptions.RestaurantException;
import com.masai.model.Category;
import com.masai.model.Item;
import com.masai.model.Restaurant;

public interface IItemService {
	
	public Item addItem(Integer catId,String itemName,Double cost, String thumbnail, String key) throws RestaurantException;
	
	public Item updateItem(Integer itemId, String itemName,Double cost,Integer catId, String thumbnail,String key)throws RestaurantException;
	
	public Item viewItem(Integer itemid,String key)throws RestaurantException;
	
	public String removeItem(Integer resId, Integer catId, Integer itemId, String key)throws RestaurantException;
	
	public List<Item> viewAllItemsInCategory(Integer catId,String key)throws RestaurantException;
	
	public List<Item> viewAllItems(Integer resId,String key)throws RestaurantException;
	
	public List<Item> viewAllItemsByName(String name,String key)throws RestaurantException;



	
	

}
