package com.masai.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String catId;
	private String categoryName;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> items = new ArrayList<>();
}
