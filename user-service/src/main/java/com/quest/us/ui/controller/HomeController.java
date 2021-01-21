package com.quest.us.ui.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class HomeController {

	@GetMapping({ "/", "/home" })
	public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		model.addAttribute("name", name);
		return "home";
	}
}
