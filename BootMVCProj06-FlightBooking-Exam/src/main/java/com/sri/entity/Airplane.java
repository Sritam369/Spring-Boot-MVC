package com.sri.entity;

import lombok.Data;

@Data
public class Airplane {

	private Integer id;
	private String pName;
	private String fName;
	private Integer ticket;
	private Double ticketPrice;
	private Double airFare;
	private Double tax;
	private Double finalAmount;
}
