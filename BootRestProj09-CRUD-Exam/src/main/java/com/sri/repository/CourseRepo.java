package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

}
