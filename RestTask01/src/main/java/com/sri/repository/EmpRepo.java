package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
