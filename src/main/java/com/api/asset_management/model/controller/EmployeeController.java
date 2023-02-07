package com.api.asset_management.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.asset_management.model.Employee;
import com.api.asset_management.model.services.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@GetMapping("/getAllEmployeeById/{employee_id}")
	public Employee getAllEmployeeById(@PathVariable String employeeId) {
		return employeeService.getAllEmployeeById(employeeId);
	}

	@PostMapping("/addEmployee")
	public void addEmployee(@RequestBody Employee emp) {
		employeeService.addEmployee(emp);
	}

	@DeleteMapping("/deleteEmployee/{employee_id}")
	public Employee deleteEmployee(@PathVariable String employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}

	//	@PutMapping("/updateEmployeeById/{employee_id}")
	//	public Employee updateEmployeeById(@PathVariable String employeeId) {
	//		return employeeService.updateEmployeeById(employeeId);
	//	}
}
