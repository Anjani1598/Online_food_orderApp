package com.masai.model;

import java.time.LocalDateTime;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String billId;
	private LocalDateTime billDate;
	private Integer totalItem;
	private Double totalCost;

}
