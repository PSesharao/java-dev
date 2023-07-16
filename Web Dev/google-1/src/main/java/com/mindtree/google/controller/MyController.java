package com.mindtree.google.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@GetMapping("/")
	public String home() {
		return "Any user can access this";
	}

	@GetMapping("/restricted")
	public Principal restricted(Principal principal) {
		return principal;
	}
	
	@GetMapping("/myself")
	public String myself()
	{
		return "Hello";
	}
}
