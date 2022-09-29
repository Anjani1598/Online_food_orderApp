package com.masai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.masai.model.Restaurant;

public interface RestaurantDao extends JpaRepository<Restaurant, String> {

}
