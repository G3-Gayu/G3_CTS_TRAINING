package com.cts.springboot.web.springbootfirstwebapplication.service;

import java.beans.JavaBean;
import java.util.List;

import com.cts.springboot.web.springbootfirstwebapplication.domain.Employee;
import com.cts.springboot.web.springbootfirstwebapplication.dto.EmployeeDTO;

@JavaBean
public interface EmployeeTrainingInterface {

	public void addEmployeeTraining(EmployeeDTO employee);

	public List<EmployeeDTO> getEmployee();

	public void updateEmployee(EmployeeDTO employee);

	public void deleteEmployee(EmployeeDTO employee);
	
	public EmployeeDTO findEmployee(EmployeeDTO employee);

}
