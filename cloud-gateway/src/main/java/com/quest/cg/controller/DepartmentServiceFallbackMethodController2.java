package com.quest.cg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentServiceFallbackMethodController2 {

	@GetMapping("/departmentServiceFallback")
	public String fallbackMethod() {
		return "Department Service is taking longer than expected." +
				"Please try again later";
	}
}
