package com.quest.cg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceFallbackMethodController {

	@GetMapping("/userServiceFallBack")
	public String fallbackMethod() {
		return "User Service is taking longer than expected." +
				"Please try again later";
	}
}
