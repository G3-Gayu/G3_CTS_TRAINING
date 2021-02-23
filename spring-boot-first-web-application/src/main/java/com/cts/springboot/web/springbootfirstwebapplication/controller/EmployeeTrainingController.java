package com.cts.springboot.web.springbootfirstwebapplication.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.springboot.web.springbootfirstwebapplication.dto.EmployeeDTO;
import com.cts.springboot.web.springbootfirstwebapplication.service.EmployeeTrainingInterface;

@Controller
public class EmployeeTrainingController {

	@Autowired
	private EmployeeTrainingInterface employeeTrainingService;
	
	@RequestMapping(value="/addEmployee",method = RequestMethod.POST)
	public String addingEmployeeFroTraining(@RequestParam String ename,
			@RequestParam int eID, @RequestParam String eTrainingname ) {
		
		EmployeeDTO employee = new EmployeeDTO();
		employee.setEmployeeID(eID);
		employee.setEmployeeName(ename);
		employee.setTraining(eTrainingname);
		
		employeeTrainingService.addEmployeeTraining(employee);
		return null;
	}
	
	

}
