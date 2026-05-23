package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.model.Orders;

public interface OrderRepo extends JpaRepository<Orders, Integer> {

}
