package com.masai.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.CustomerItem;
import com.masai.model.FoodCart;

public interface FoodCartDao extends JpaRepository<FoodCart, String> {
	
	public FoodCart findByCustomerItems(CustomerItem customerItem);

}
