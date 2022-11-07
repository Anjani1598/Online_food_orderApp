package com.masai.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Bill;
import com.masai.model.FoodCart;
import com.masai.model.OrderDetails;

public interface BillDao extends JpaRepository<Bill, String> {
	
	public List<Bill> findByCart(FoodCart cart);
	
	public Bill findByOrder(OrderDetails order);
	

}
