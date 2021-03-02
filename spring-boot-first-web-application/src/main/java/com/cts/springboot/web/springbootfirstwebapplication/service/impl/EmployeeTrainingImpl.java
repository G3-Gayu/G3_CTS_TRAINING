package com.cts.springboot.web.springbootfirstwebapplication.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.springboot.web.springbootfirstwebapplication.domain.Employee;
import com.cts.springboot.web.springbootfirstwebapplication.domain.Training;
import com.cts.springboot.web.springbootfirstwebapplication.dto.EmployeeDTO;
import com.cts.springboot.web.springbootfirstwebapplication.dto.TrainingDTO;
import com.cts.springboot.web.springbootfirstwebapplication.repo.EmployeeRepository;
import com.cts.springboot.web.springbootfirstwebapplication.service.EmployeeTrainingInterface;

@Service
public class EmployeeTrainingImpl implements EmployeeTrainingInterface {

	@Autowired
	EmployeeRepository employeeRepo;

	Logger logger = LoggerFactory.logger(EmployeeTrainingImpl.class);

	@Override
	public void addEmployeeTraining(EmployeeDTO employeeDTO) {

		Employee employee = new Employee();
		employee.setEmployeeID(employeeDTO.getEmployeeID());
		employee.setEmployeeName(employeeDTO.getEmployeeName());
		Training training = new Training();
		training.setTraining(employeeDTO.getTrainingDTO().getTrainingName());
		employee.setTraining(training);
		employeeRepo.save(employee);
		logger.info("employee saved successfully");

	}

	@Override
	public List<EmployeeDTO> getEmployee() {

		List<Employee> employeeList = (List<Employee>) employeeRepo.findAll();
		logger.info("get method excuted");
		List<EmployeeDTO> employeeDTOList = new ArrayList<>();
		employeeList.stream().forEachOrdered(emp -> {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployeeID(emp.getEmployeeID());
			employeeDTO.setEmployeeName(emp.getEmployeeName());
			employeeDTO.setId(emp.getId());
			TrainingDTO trainingDto = new TrainingDTO();
			trainingDto.setId(emp.getTraining().getId());
			trainingDto.setTrainingName(emp.getTraining().getTraining());
			employeeDTO.setTrainingDTO(trainingDto);
			employeeDTOList.add(employeeDTO);
		});

		return employeeDTOList;
	}

	@Override
	public void updateEmployee(EmployeeDTO employee) {

		Optional<Employee> employ = employeeRepo.findOneById(employee.getId());
		if (employ.isPresent()) {
			Training newtraining = employ.get().getTraining();
			newtraining.setTraining(employee.getTrainingDTO().getTrainingName());
			Employee emp = employ.get();
			emp.setTraining(newtraining);
			employeeRepo.save(emp);
		}

		logger.info("data Updated successfully");

	}

	@Override
	public void deleteEmployee(EmployeeDTO employee) {
		employeeRepo.deleteById(employee.getId());
		logger.info("data deleted successfully");

	}

	public EmployeeDTO findEmployee(EmployeeDTO employee) {
		logger.info("finding employee details " + employee.getId());
		EmployeeDTO foundEmployee = new EmployeeDTO();

		Optional<Employee> employ = employeeRepo.findOneById(employee.getId());
		// Optional<Employee> employ = employeeRepo.findById(employee.getId());
		if (employ.isPresent()) {
			Employee newEmployee = employ.get();
			logger.info("found employee details" + newEmployee);

			foundEmployee.setId(newEmployee.getId());
			foundEmployee.setEmployeeName(newEmployee.getEmployeeName());
			foundEmployee.setEmployeeID(newEmployee.getEmployeeID());
			TrainingDTO trainingDto = new TrainingDTO();
			trainingDto.setId(newEmployee.getTraining().getId());
			trainingDto.setTrainingName(newEmployee.getTraining().getTraining());
			foundEmployee.setTrainingDTO(trainingDto);
			

		}
		return foundEmployee;
	}

}
