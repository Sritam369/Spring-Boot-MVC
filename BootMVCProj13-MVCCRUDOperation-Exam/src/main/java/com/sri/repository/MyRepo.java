package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.FoodOrder;

public interface MyRepo extends JpaRepository<FoodOrder, Integer> {

}
