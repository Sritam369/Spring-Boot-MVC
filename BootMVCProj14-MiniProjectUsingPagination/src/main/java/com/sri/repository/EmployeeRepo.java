package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
