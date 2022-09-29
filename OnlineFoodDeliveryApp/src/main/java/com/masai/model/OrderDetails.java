package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	private LocalDateTime orderDate;
	
	@OneToOne
	private FoodCart cart;
	
	@OneToOne
	@JoinColumn(name = "bill_id", referencedColumnName = "billId")
	private Bill bill;
	
	private String orderStatus;
	
	
	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", orderDate=" + orderDate + ", cart=" + cart + ", orderStatus="
				+ orderStatus + "]";
	}
	
	
	
	

}

