package com.masai.model;

import java.time.LocalDateTime;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name = "orderDetails_id", referencedColumnName = "orderId")
	@JsonIgnore
	private OrderDetails order;

}
