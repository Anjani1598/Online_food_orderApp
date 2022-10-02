package com.masai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.masai.model.OrderDetails;

public interface OrderDetailsDao extends JpaRepository<OrderDetails, Integer> {
	
	

}
