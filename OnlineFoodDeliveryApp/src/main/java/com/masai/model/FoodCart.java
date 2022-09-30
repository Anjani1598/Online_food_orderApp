package com.masai.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
public class FoodCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String cartId;
	
	@OneToOne
	private Customer customer;
	
//	@OneToOne
//	@JoinColumn(name = "orderDetails_id", referencedColumnName = "orderId")
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderDetails> order = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Item> itemList = new HashSet<>();

	@Override
	public String toString() {
		return "FoodCart [cartId=" + cartId + ", customer=" + customer + "]";
	}

}
