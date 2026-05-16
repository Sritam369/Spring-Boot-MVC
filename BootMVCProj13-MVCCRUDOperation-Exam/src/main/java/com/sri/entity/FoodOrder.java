package com.sri.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="food_order_mvc")
@NoArgsConstructor
@RequiredArgsConstructor
public class FoodOrder {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "seq1",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="gen1", strategy=GenerationType.SEQUENCE)
	private Integer orderId;
	@NonNull
	private String custName;
	@NonNull
	private String itemName;
	@NonNull
	private Integer quantity;
	@NonNull
	private Double price;
		
	private Double totalAmt;
	
	public void setTotalAmt() {
		Double totalAmt=getPrice()*getQuantity();
		this.totalAmt = totalAmt;
	}
	
	
}
