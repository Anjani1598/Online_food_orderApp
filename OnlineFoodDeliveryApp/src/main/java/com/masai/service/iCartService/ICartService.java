package com.masai.service.iCartService;

import com.masai.model.FoodCart;
import com.masai.model.Item;
import com.masai.exceptions.CustomerException;
import com.masai.exceptions.FoodCartException;
import com.masai.exceptions.ItemException;

public interface ICartService {
	
	public FoodCart addItemToCart(Item item, String key)throws FoodCartException, ItemException, CustomerException;
	
	public FoodCart increaseQuantity(FoodCart cart, Item item, Integer quantity) throws FoodCartException,ItemException;
	
	public FoodCart reduceQuantity(FoodCart cart, Item item, Integer quantity)throws FoodCartException,ItemException;

	public FoodCart removeItem(FoodCart cart, Item item)throws FoodCartException,ItemException;
	
	public FoodCart clearCart(FoodCart cart)throws FoodCartException;

}
