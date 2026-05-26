package com.sri.rest;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageRenderController {

	@GetMapping("/msg")
	public ResponseEntity<String> showMsg(){
		LocalDateTime ldt = LocalDateTime.now();
		String msg = null;
		if(ldt.getHour()<12) {
			msg="Good Morning";
		}
		else if(ldt.getHour()<16) {
			msg="Good Afternoon";
		}
		else {
			msg="Good Evening";
		}
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
