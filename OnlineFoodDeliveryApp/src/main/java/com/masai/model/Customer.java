package com.masai.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;



@Entity
@Data
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String firstName;
	private String lastName;
	private Integer age;
	private String gender;
	
	@Embedded
	@ElementCollection
	private Set<Address> address = new HashSet<>();
	private String email;
	
	@OneToOne
	@JoinColumn(name = "cart_id", referencedColumnName = "cartId")
	private FoodCart cart;
	
	
	
	
	
	


	
	
	
	

}
