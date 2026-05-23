package com.sri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sri.model.Orders;
import com.sri.repository.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo repo;
	
	public Page<Orders> getOrders(Pageable page){
		  Page<Orders> all = repo.findAll(page);
		return all;
	}
	
	public String addOrder(Orders o) {
		Orders save = repo.save(o);
		return "Order added";
	}
	
	public Orders editOrder(Integer id) {
		Orders byId = repo.findById(id).get();
		return byId;
	}
	
	public String update(Orders o) {
		repo.save(o);
		return "Order updated";
	}
	
	public String delete(Integer id) {
		repo.deleteById(id);
		return "Order deleted";
	}
}
