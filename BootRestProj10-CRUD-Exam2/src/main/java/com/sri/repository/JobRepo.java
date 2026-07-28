package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.Job;

public interface JobRepo extends JpaRepository<Job,Integer> {

}
