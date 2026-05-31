package com.sri.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

	private Integer pid;
	private String pname;
	private String catagory;
	private Double price;
}
