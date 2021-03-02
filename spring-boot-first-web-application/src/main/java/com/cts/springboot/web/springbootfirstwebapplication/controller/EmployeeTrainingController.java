package com.cts.springboot.web.springbootfirstwebapplication.controller;

import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cts.springboot.web.springbootfirstwebapplication.domain.Employee;
import com.cts.springboot.web.springbootfirstwebapplication.dto.EmployeeDTO;
import com.cts.springboot.web.springbootfirstwebapplication.dto.TrainingDTO;
import com.cts.springboot.web.springbootfirstwebapplication.service.EmployeeTrainingInterface;
import com.mysql.cj.util.StringUtils;

@Controller
public class EmployeeTrainingController {

	@Autowired
	private EmployeeTrainingInterface employeeTrainingService;

	Logger logger = LoggerFactory.logger(EmployeeTrainingController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	// @ResponseBody
	public String HelloMessage(Model model) {
		List<EmployeeDTO> employeeDTOList = employeeTrainingService.getEmployee();

		model.addAttribute("emp", employeeDTOList);
		model.addAttribute("loginInUser", getLoggedinUserName());

		return "hello";
	}

	private String getLoggedinUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

	@PostMapping("/addEmployee")
	public String addingEmployeeFroTraining(@RequestParam String ename, @RequestParam int eID,
			@RequestParam String eTrainingname) {

		EmployeeDTO employee = new EmployeeDTO();
		employee.setEmployeeID(eID);
		employee.setEmployeeName(ename);
		TrainingDTO trainingDTO = new TrainingDTO();
		trainingDTO.setTrainingName(eTrainingname);

		employee.setTrainingDTO(trainingDTO);

		employeeTrainingService.addEmployeeTraining(employee);
		return "redirect:/login";
	}

	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
	public String getEmployee(Model model) {
		List<EmployeeDTO> employeeDTOList = employeeTrainingService.getEmployee();

		model.addAttribute("emp", employeeDTOList);
		return "listEmployee";
	}

	@RequestMapping(value = "/fetchEmployee", method = RequestMethod.GET)
	public String fetchEmployee(@RequestParam Long id, ModelMap model) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(id);
		EmployeeDTO foundEMployee = employeeTrainingService.findEmployee(employeeDTO);
		model.addAttribute("emp", foundEMployee);

		return "update";
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public String updateEmployee(@RequestParam Long id, @RequestParam String eTrainingname) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(id);
		if (!StringUtils.isNullOrEmpty(eTrainingname)) {
			TrainingDTO trainingDTO = new TrainingDTO();
			trainingDTO.setTrainingName(eTrainingname);
			employeeDTO.setTrainingDTO(trainingDTO);
		} else {
			throw new RuntimeException("Something went wrong");
		}

		employeeTrainingService.updateEmployee(employeeDTO);

		return "redirect:/login";
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public String deleteEmployee(@RequestParam Long id) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(id);
		employeeTrainingService.deleteEmployee(employeeDTO);

		return "redirect:/login";
	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)

	public String success(Model model) {
		return "redirect:/login";
	}

	@GetMapping("/checkStatus")
	// @RequestMapping(value = "/checkStatus", method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public void sendViaResponseEntity() {
		logger.info(HttpStatus.OK);
		// return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
	}

}
