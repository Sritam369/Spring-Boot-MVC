package com.sri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.Course;
import com.sri.repository.CourseRepo;

@Service
public class CourseService {

	@Autowired
	private CourseRepo repo;
	
	public String addCourse(Course c) {
		Course save = repo.save(c);
		return "Course saved with id: "+save.getCourseId();
	}
	
	public List<Course>viewAll(){
		List<Course> all = repo.findAll();
		return all;
	}
	
	public Course viewById(Integer id){
		Course c = repo.findById(id).get();
		return c;
	}
	
	public String update(Course id) {
		Course save = repo.save(id);
		return save.getCourseId()+" Course updated";
	}
	
	public String delete(Integer id) {
		Course byId = repo.findById(id).get();
		repo.delete(byId);
		return "course deleted with id : "+byId.getCourseId();
	}
}
