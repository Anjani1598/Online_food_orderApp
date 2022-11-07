package com.masai.model;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
@EqualsAndHashCode
@ToString
@Data
public class Address {
	
	
	private String buildingName;
	private String streetNo;
	private String area;
	private String city;
	private String state;
	private String country;
	private String pincode;
	
	

}
