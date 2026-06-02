package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.model.Tourist;

public interface TouristRepo extends JpaRepository<Tourist, Integer> {

}
