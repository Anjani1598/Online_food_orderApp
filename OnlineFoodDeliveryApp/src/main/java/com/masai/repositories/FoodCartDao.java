package com.masai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.masai.model.FoodCart;

public interface FoodCartDao extends JpaRepository<FoodCart, String> {

}
