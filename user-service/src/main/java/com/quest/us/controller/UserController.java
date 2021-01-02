package com.quest.us.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quest.us.VO.ResponseTemplateVo;
import com.quest.us.entity.User;
import com.quest.us.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@PostMapping("/")
	public User saveUser(User user) {
		log.info("Inside saveUser() method of UserController.");
		return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVo getUserWithDepartment(@PathVariable("id") Long userId) {
		log.info("Inside getUserWithDepartment() method of UserController.");
		return userService.getUserWithDepartment(userId);
	}
}
