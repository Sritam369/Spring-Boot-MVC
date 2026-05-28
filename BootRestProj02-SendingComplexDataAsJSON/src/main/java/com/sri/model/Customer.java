package com.sri.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	private Integer cno;
	private String cname;
	private Float billAmt;
	private String[] favColors;
	private List<String> friends;
	private Set<String> phones;
	private Map<String,String> idDetails;
	private Company company;
}
