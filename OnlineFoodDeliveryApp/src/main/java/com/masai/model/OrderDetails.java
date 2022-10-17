package com.masai.model;

import java.time.LocalDateTime;


import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Integer orderId;
	private LocalDateTime orderDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Restaurant restaurant;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Bill bill;
	
	private String orderStatus;
	
	
	@Override
	public String toString() {
//<<<<<<< HEAD
//		return "OrderDetails [orderId=" + orderId + ", orderDate=" + orderDate + "orderStatus="
//=======
		return "OrderDetails [orderId=" + orderId + ", orderDate=" + orderDate +  ", orderStatus="
//>>>>>>> 77843e2970ffc4a507357f6a45688b64d7408bfc
				+ orderStatus + "]";
	}
	
	
	
	

}

