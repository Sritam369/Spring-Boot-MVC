package com.sri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.Job;
import com.sri.repository.JobRepo;

@Service
public class JobService {

	@Autowired
	private JobRepo repo;
	
	public String addCourse(Job c) {
		if(c.getJobTitle().isEmpty()) {
			return "Job title can't be blank";
		}
		if(c.getCompanyName().length()<3) {
			return "Company name must be atleast 3 characters";
		}
		if(c.getSalary()<0) {
			return "Salary must be greater than 0";
		}
		else {
		Job save = repo.save(c);
		return "Course saved with id: "+save.getJobId();
		}
	}
	
	public List<Job>viewAll(){
		List<Job> all = repo.findAll();
		return all;
	}
	
	public Job viewById(Integer id){
		Job c = repo.findById(id).get();
		return c;
	}
	
	public String update(Job id) {
		Job save = repo.save(id);
		return save.getJobId()+" Course updated";
	}
	
	public String delete(Integer id) {
		Job byId = repo.findById(id).get();
		repo.delete(byId);
		return "course deleted with id : "+byId.getJobId();
	}
}
