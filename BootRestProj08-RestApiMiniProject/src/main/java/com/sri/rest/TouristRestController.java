package com.sri.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sri.service.ITouristService;
import com.sri.vo.TouristVo;

@RestController
public class TouristRestController {

	@Autowired
	private ITouristService service;
	
	@PostMapping("/reg")
	public ResponseEntity<String> register(@RequestBody TouristVo t){
		String msg = service.register(t);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<TouristVo>> getAllTourist(){
		List<TouristVo> allTourist = service.findAllTourist();
		return new ResponseEntity<List<TouristVo>>(allTourist,HttpStatus.OK);
	}
	
	@PatchMapping("/partial/{id}/{per}")
	public ResponseEntity<String> partialUpdate(@PathVariable Integer id,@PathVariable Double per){
		String partialUpdate = service.partialUpdate(id, per);
		return new ResponseEntity<String>(partialUpdate,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateTourist(@RequestBody TouristVo vo){
		String fullUpdate = service.fullUpdate(vo);
		return new ResponseEntity<String>(fullUpdate,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTourist(@PathVariable Integer id){
		String deleteTourist = service.deleteTourist(id);
		return new ResponseEntity<String>(deleteTourist,HttpStatus.OK);
	}
}
