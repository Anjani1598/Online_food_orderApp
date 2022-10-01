package com.masai.model;

import java.util.HashSet;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer restaurantId;
	private String restaurantName;
	
	
	@ElementCollection
	@Embedded
	private Set<Address> address = new HashSet<>();
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Item> items = new HashSet<>();
	
	
	private String managerName;
	private String contactNumber;
	
	
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", managerName="
				+ managerName + ", contactNumber=" + contactNumber + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		return Objects.equals(address, other.address) && Objects.equals(contactNumber, other.contactNumber)
				&& Objects.equals(managerName, other.managerName) && Objects.equals(restaurantId, other.restaurantId)
				&& Objects.equals(restaurantName, other.restaurantName);
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(address, contactNumber, managerName, restaurantId, restaurantName);
	}
	
	
	

}

