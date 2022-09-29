package com.masai.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;




@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String itemId;
	private String itemName;
	
	@OneToOne
	@JoinColumn(name = "category_id", referencedColumnName = "catId")
	private Category category;
	

	private Integer quantity;
	private double cost;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Restaurant> restaurants = new HashSet<>();
	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", quantity=" + quantity + ", cost=" + cost + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, itemId, itemName, quantity);
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
				&& Objects.equals(quantity, other.quantity);
	}
	
	
	

}