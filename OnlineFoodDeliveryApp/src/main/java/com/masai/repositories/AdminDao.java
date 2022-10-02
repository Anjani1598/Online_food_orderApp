package com.masai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.RestaurantAdmin;

public interface AdminDao extends JpaRepository<RestaurantAdmin, Integer>{

	
	public RestaurantAdmin findByMobileNumber(String mobileNumber);

}
