package com.masai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.masai.model.FoodCart;

public interface FoodCarDao extends JpaRepository<FoodCart, String> {

}
