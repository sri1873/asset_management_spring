package com.api.asset_management.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.asset_management.model.Department;
import com.api.asset_management.payload.DepartmentRequest;
import com.api.asset_management.services.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/getAllDepartment")
	public List<Department> getAllDepartment() {
		return departmentService.getAllDepartment();
	}

	@GetMapping("/getDepartmentById/{departmentId}")
	public Department getDepartmentById(@PathVariable UUID departmentId) {
		return departmentService.getDepartmentById(departmentId);
	}

	@PostMapping("/addDepartment")
	public void addDepartment(@Valid @RequestBody DepartmentRequest department) {
		departmentService.addDepartment(department);
	}

	@DeleteMapping("/deleteDepartment/{departmentId}")
	public Department addDepartment(@PathVariable UUID departmentId) {
		return departmentService.deleteDepartment(departmentId);
	}

}
