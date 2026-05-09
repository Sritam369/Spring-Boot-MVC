package com.sri.entity;

import lombok.Data;

public class Customer {

	private Integer id;
	private String sName;
	private String pName;
	private Integer qty;
	private Double price;
	private Double gst;
	private Double discount;
	private Double bill;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getGst() {
		return gst;
	}
	public void setGst(Double gst) {
		this.gst = gst;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getBill() {
		return bill;
	}
	public void setBill(Double bill) {
		this.bill = bill;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", sName=" + sName + ", pName=" + pName + ", qty=" + qty + ", price=" + price
				+ ", gst=" + gst + ", discount=" + discount + ", bill=" + bill + "]";
	}
	
	
	
}
