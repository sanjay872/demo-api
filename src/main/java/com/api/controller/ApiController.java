package com.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ApiController {

	@GetMapping()
	public String welcome() {
		return "hello welcome!!";
	}
	
//	@GetMapping("/bye")
//	public String bye() {
//		return "Bye!!";
//	}
	
	@GetMapping("hey")
	public String hey() {
		return "Hey :)!!";
	}
}
