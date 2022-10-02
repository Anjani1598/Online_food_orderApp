package com.masai.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer catId;
	private String categoryName;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Item> items = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Restaurant> restaurants = new HashSet<>();
}
