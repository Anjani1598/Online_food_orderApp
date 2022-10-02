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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
public class FoodCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Integer cartId;
	
	@OneToOne
	@JsonIgnore
	private Customer customer;
	
//	@OneToOne
//	@JoinColumn(name = "orderDetails_id", referencedColumnName = "orderId")
//	@OneToMany(cascade = CascadeType.ALL)
//	@JsonIgnore
//	private List<OrderDetails> order = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Item> itemList = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Bill> bills = new HashSet<>();

	@Override
	public String toString() {
		return "FoodCart [cartId=" + cartId + ", customer=" + customer + "]";
	}

}
