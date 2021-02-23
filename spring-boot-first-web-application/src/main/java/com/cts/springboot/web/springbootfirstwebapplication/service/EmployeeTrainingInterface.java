package com.cts.springboot.web.springbootfirstwebapplication.service;

import org.springframework.stereotype.Service;

import com.cts.springboot.web.springbootfirstwebapplication.dto.EmployeeDTO;

@Service
public interface EmployeeTrainingInterface {
	
	public void addEmployeeTraining(EmployeeDTO employee);

}
