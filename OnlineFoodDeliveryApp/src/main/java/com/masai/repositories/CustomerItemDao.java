package com.masai.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.CustomerItem;
import com.masai.model.FoodCart;
import com.masai.model.Item;

public interface CustomerItemDao extends JpaRepository<CustomerItem, Integer> {
	
	public List<CustomerItem> findByCart(FoodCart cart);
	
	public List<CustomerItem> findByItem(Item item);
	


}
