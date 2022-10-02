package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Integer billId;
	private LocalDateTime billDate;
	private Integer totalItem;
	private Double totalCost;
	
	@OneToOne
	@JsonIgnore
	private OrderDetails order;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private FoodCart cart;

}
