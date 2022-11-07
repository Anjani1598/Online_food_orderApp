package com.masai.model;

import java.util.List;

import lombok.Data;

@Data
public class BillItemDto {
	
	private String item;
	
	private Integer quantity;
	
	private Double itemCost;

}
