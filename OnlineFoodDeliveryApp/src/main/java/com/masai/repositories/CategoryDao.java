package com.masai.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.masai.model.Category;
import com.masai.model.Restaurant;

public interface CategoryDao extends JpaRepository<Category, Integer>{
	
	public List<Category> findByRestaurants(Restaurant res);
	
	

}
