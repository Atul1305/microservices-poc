package com.quest.ds.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quest.ds.entity.Department;
import com.quest.ds.repository.DepartmentRepository;

@Service
public class DepartmentService {

	private static Logger log = LoggerFactory.getLogger(DepartmentService.class);
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		log.info("Inside saveDepartment method of DepartmentService.");
		return departmentRepository.save(department);
	}

	public Department findDepartmentById(Long departmentId) {
		log.info("Inside findDepartmentById method of DepartmentService for departmentId: {}", departmentId);
		return departmentRepository.findByDepartmentId(departmentId);
	}
}
