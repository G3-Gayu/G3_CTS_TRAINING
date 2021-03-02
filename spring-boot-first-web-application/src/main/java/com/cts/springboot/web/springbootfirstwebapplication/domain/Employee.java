package com.cts.springboot.web.springbootfirstwebapplication.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "employee")
public class Employee {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String employeeName;

	@NotNull
	private int employeeID;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "training_id", referencedColumnName = "id")
	private Training training;

	public Employee() {
	}

	public Employee(String employeeName, int employeeID) {
		this.employeeName = employeeName;
		this.employeeID = employeeID;
		
	}
	

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	
}
