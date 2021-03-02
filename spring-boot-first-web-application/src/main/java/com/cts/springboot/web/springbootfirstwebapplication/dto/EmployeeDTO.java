package com.cts.springboot.web.springbootfirstwebapplication.dto;

public class EmployeeDTO {

	private String employeeName;
	private int employeeID;
	private TrainingDTO trainingDTO;
	private Long id;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TrainingDTO getTrainingDTO() {
		return trainingDTO;
	}

	public void setTrainingDTO(TrainingDTO trainingDTO) {
		this.trainingDTO = trainingDTO;
	}

}
