package com.masai.model;

import java.util.ArrayList;


import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;



@Data
@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId;
	private String itemName;
	private String itemThumbnail;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Category category;
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JsonIgnore
//	private Set<FoodCart> cart = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<CustomerItem> customerItems = new ArrayList<>(); 
	private double cost;
	
	@ManyToOne(cascade = CascadeType.ALL)
//	@JsonIgnore
	Restaurant restaurant;

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName +", cost=" + cost + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost)
				&& Objects.equals(itemId, other.itemId) && Objects.equals(itemName, other.itemName)
				;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, itemId, itemName);
	}
	
	

	
	
	
	

}
