package com.sri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.FoodOrder;
import com.sri.repository.MyRepo;



@Service
public class MyService {

	@Autowired
	private MyRepo repo;
	
	public List<FoodOrder> show() {
		List<FoodOrder> list = repo.findAll();
		return list;
	}
	
	public String insert(FoodOrder o) {
		FoodOrder save = repo.save(o);
		return "Order saved";
	}
	
	public FoodOrder findOrderById(Integer id) {
		FoodOrder byId = repo.findById(id).get();
		return byId;
	}
	
	public String update(FoodOrder o) {
		FoodOrder save = repo.save(o);
		return "Order updated";
	}
	
	public String delete(Integer id) {
		FoodOrder foodOrder = repo.findById(id).get();
		repo.delete(foodOrder);
		return "Food order with id : "+foodOrder.getOrderId()+" deleted";
	}
	
}
