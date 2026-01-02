package com.example.crud_operations.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	@GetMapping("/login")
	public String login() {
		return "Login page...";
	}
	
}
