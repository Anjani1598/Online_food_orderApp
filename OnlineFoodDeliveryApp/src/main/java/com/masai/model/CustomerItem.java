package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class CustomerItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerItemId;
	
	private Integer quantity;
	
	@ManyToOne
	private Item item;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private FoodCart cart;
	
	
	
	

}
