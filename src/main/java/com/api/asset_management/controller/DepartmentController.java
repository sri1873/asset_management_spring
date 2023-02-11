package com.api.asset_management.controller;

import java.util.UUID;

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

import com.api.asset_management.model.Department;
import com.api.asset_management.payload.ApiResponse;
import com.api.asset_management.payload.DepartmentRequest;
import com.api.asset_management.services.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/getAllDepartment")
	public ResponseEntity<ApiResponse> getAllDepartment() {
		ApiResponse departments = departmentService.getAllDepartment();
		return new ResponseEntity<>(departments, HttpStatus.OK);
	}

	@GetMapping("/getDepartmentById/{departmentId}")
	public ResponseEntity<ApiResponse> getDepartmentById(@PathVariable UUID departmentId) {
		ApiResponse department = departmentService.getDepartmentById(departmentId);
		return new ResponseEntity<>(department, HttpStatus.OK);
	}

	@PostMapping("/addDepartment")
	public ResponseEntity<Department> addDepartment(@Valid @RequestBody DepartmentRequest department) {
		return new ResponseEntity<>(departmentService.addDepartment(department), HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteDepartment/{departmentId}")
	public Department addDepartment(@PathVariable UUID departmentId) {
		return departmentService.deleteDepartment(departmentId);
	}

}
