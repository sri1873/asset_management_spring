package com.api.asset_management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.asset_management.model.Employee;
import com.api.asset_management.model.Item;
import com.api.asset_management.payload.EmployeeRequest;
import com.api.asset_management.services.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@GetMapping("/getAllEmployeeById/{employeeId}")
	public Employee getAllEmployeeById(@PathVariable String employeeId) {
		return employeeService.getAllEmployeeById(employeeId);
	}

	@PostMapping("/addEmployee")
	public void addEmployee(@Valid @RequestBody EmployeeRequest emp) {
		employeeService.addEmployee(emp);
	}

	@DeleteMapping("/deleteEmployee/{employeeId}")
	public Employee deleteEmployee(@PathVariable String employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}

	//	@PutMapping("/updateEmployeeById/{employeeId}")
	//	public Employee updateEmployeeById(@PathVariable String employeeId) {
	//		return employeeService.updateEmployeeById(employeeId);
	//	}

	@GetMapping("/getAllAssignedItems/{employeeId}")
	public Item getAllAssignedItems(@PathVariable String employeeId) {
		return employeeService.getAllAssignedItems(employeeId);
	}
}
