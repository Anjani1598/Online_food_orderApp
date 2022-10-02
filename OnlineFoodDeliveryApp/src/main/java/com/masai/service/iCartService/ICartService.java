package com.masai.service.iCartService;

import com.masai.model.FoodCart;
import com.masai.model.Item;
import com.masai.exceptions.CustomerException;
import com.masai.exceptions.FoodCartException;
import com.masai.exceptions.ItemException;

public interface ICartService {
	
	public FoodCart addItemToCart(Item item, String key)throws FoodCartException, ItemException, CustomerException;
	
	public FoodCart increaseQuantity(Item item, Integer quantity,String key) throws FoodCartException,ItemException,CustomerException;
	
	public FoodCart reduceQuantity(Item item, Integer quantity,String key)throws FoodCartException,ItemException, CustomerException;

	public FoodCart removeItem(Item item, String key)throws FoodCartException,ItemException;
	
	public FoodCart clearCart(String key)throws FoodCartException,CustomerException;

}
