package com.masai.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
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
	private Integer billId;
	private LocalDateTime billDate;
	private Integer totalItem;
	private Double totalCost;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private OrderDetails order;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private FoodCart cart;
	
	@Embedded
	@ElementCollection
	private Set<BillItemDto> billItems = new HashSet<>();
	

	public Set<BillItemDto> getBillItems() {
		
		
		for(CustomerItem item : cart.getCustomerItems()) {
			
			String itemName = item.getItem().getItemName();
			Integer qty = item.getQuantity();
			Double itemCost = item.getItem().getCost();
			
			BillItemDto billItem = new BillItemDto();
			billItem.setItem(itemName);
			billItem.setQuantity(qty);
			billItem.setItemCost(itemCost);
			
			billItems.add(billItem);
			
		
			
		}
		return billItems;
	}

	public void setBillItems(Set<BillItemDto> billItems) {
		this.billItems = billItems;
	}
	
	
	

}
