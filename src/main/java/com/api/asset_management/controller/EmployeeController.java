package com.api.asset_management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.asset_management.model.Employee;
import com.api.asset_management.payload.ApiResponse;
import com.api.asset_management.payload.EmployeeRequest;
import com.api.asset_management.services.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getAllEmployee")
	public ResponseEntity<ApiResponse> getAllEmployee() {
		ApiResponse emps = employeeService.getAllEmployee();
		return new ResponseEntity<>(emps, HttpStatus.OK);
	}

	@GetMapping("/getAllEmployeeById/{employeeId}")
	public ResponseEntity<ApiResponse> getAllEmployeeById(@PathVariable String employeeId) {
		ApiResponse emp = employeeService.getAllEmployeeById(employeeId);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody EmployeeRequest emp) {
		return new ResponseEntity<>(employeeService.addEmployee(emp), HttpStatus.CREATED);
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
	public ResponseEntity<ApiResponse> getAllAssignedItems(@PathVariable String employeeId) {
		ApiResponse itm = employeeService.getAllAssignedItems(employeeId);
		return new ResponseEntity<>(itm, HttpStatus.OK);
	}
}
