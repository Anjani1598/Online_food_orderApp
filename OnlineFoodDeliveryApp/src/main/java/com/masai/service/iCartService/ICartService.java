package com.masai.service.iCartService;

import com.masai.model.FoodCart;
import com.masai.model.Item;
import com.masai.exceptions.CustomerException;
import com.masai.exceptions.FoodCartException;
import com.masai.exceptions.ItemException;

public interface ICartService {
	
	public FoodCart addItemToCart(Integer itemId,String key)throws FoodCartException, ItemException, CustomerException;
	
	public FoodCart increaseQuantity(Integer itemId,String key) throws FoodCartException,ItemException,CustomerException;
	
	public FoodCart reduceQuantity(Integer itemId, Integer quantity,String key)throws FoodCartException,ItemException, CustomerException;

	public FoodCart removeItem(Integer itemId, String key)throws FoodCartException,ItemException;
	
	public FoodCart clearCart(String key)throws FoodCartException,CustomerException;

}
