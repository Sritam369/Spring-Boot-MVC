package com.sri.model;

public class Product {

	private Integer id;
	private String name;
	private Double price;
	public Product(Integer id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "" + id + " " + name + " " + price + "";
	}
	
}
