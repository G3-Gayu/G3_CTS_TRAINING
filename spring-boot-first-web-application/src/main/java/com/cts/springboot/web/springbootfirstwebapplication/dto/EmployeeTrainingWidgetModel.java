package com.cts.springboot.web.springbootfirstwebapplication.dto;

import org.springframework.stereotype.Component;

@Component
public class EmployeeTrainingWidgetModel {

	private String employeeName;
	private String employeeID;
	private String training;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getTraining() {
		return training;
	}

	public void setTraining(String training) {
		this.training = training;
	}

}
