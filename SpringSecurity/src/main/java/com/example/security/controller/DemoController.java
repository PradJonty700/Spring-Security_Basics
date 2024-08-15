package com.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/hello")
	public String greet() {
		return "Hello World";
	}
	//player
	@GetMapping("/player") 
	public String playerApi() {
		return "Hello Football Player";
	}
	//coach
	@GetMapping("/coach")
	public String coachApi() {
		return "Hello Coach";
	}
	//president
	@GetMapping("/president") 
	public String presidentApi() {
		return "Hello President";
	}
	//president,coach
	@GetMapping("/transfer")
	public String statsApi() {
		return "Hello President";
	}
}
