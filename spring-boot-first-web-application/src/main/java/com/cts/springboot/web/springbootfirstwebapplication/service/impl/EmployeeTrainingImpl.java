package com.cts.springboot.web.springbootfirstwebapplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cts.springboot.web.springbootfirstwebapplication.domain.Employee;
import com.cts.springboot.web.springbootfirstwebapplication.dto.EmployeeDTO;
import com.cts.springboot.web.springbootfirstwebapplication.repo.EmployeeRepository;
import com.cts.springboot.web.springbootfirstwebapplication.service.EmployeeTrainingInterface;

public class EmployeeTrainingImpl implements EmployeeTrainingInterface {

	@Autowired
	EmployeeRepository employeeRepo;

	@Override
	public void addEmployeeTraining(EmployeeDTO employeeDTO) {

		Employee employee = new Employee();
		employee.setEmployeeID(employeeDTO.getEmployeeID());
		employee.setEmployeeName(employeeDTO.getEmployeeName());
		employee.setTraining(employeeDTO.getTraining());
		employeeRepo.save(employee);

	}

}
