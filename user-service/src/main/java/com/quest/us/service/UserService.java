package com.quest.us.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.quest.us.VO.Department;
import com.quest.us.VO.ResponseTemplateVo;
import com.quest.us.entity.User;
import com.quest.us.repository.UserRepository;

@Service
public class UserService {
	
	private static Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("Inside saveUser() method of UserService.");
		return userRepository.save(user);
	}

	public ResponseTemplateVo getUserWithDepartment(Long userId) {
		log.info("Inside getUserWithDepartment() method of UserService.");
		ResponseTemplateVo responseTemplateVo = new ResponseTemplateVo();
		
		User user = userRepository.findByUserId(userId);
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId() , Department.class);
		
		responseTemplateVo.setUser(user);
		responseTemplateVo.setDepartment(department);
		
		return responseTemplateVo;
	}
	

}
