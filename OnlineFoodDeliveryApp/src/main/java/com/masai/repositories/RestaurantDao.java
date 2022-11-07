package com.masai.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Restaurant;

public interface RestaurantDao extends JpaRepository<Restaurant, Integer> {
	
	public Restaurant findByMobileNumber(String mobileNumber);
	
	public List<Restaurant> findByOrderByRatingDesc();
	
	public List<Restaurant> findByOrderByDeliveryTimeDesc();
	
	public List<Restaurant> findByOrderByDiscountDesc();



}
