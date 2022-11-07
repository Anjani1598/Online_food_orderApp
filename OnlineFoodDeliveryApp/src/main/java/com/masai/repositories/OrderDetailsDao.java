package com.masai.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Bill;
import com.masai.model.OrderDetails;
import com.masai.model.Restaurant;

public interface OrderDetailsDao extends JpaRepository<OrderDetails, Integer> {
	
	public List<OrderDetails> findByRestaurant(Restaurant restaurant);
	public List<OrderDetails> findByRestaurantRestaurantId(Integer restaurantid);
	
	public OrderDetails findByBill(Bill bill);
	
}
