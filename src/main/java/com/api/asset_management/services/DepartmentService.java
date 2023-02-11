package com.api.asset_management.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.asset_management.exception.ResourceNotFoundException;
import com.api.asset_management.model.Department;
import com.api.asset_management.payload.ApiResponse;
import com.api.asset_management.payload.DepartmentRequest;
import com.api.asset_management.repository.DepartmentRepository;
import com.api.asset_management.utils.AppConstants;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public ApiResponse getAllDepartment() {
		List<Department> departments = departmentRepository.findAll();
		return ApiResponse.builder().data(departments).status(HttpStatus.OK).message(AppConstants.RETRIEVAL_SUCCESS)
				.success(Boolean.TRUE).errors(new ArrayList<>()).build();
	}

	public ApiResponse getDepartmentById(UUID departmentId) {
		Department department = departmentRepository.findByUuid(departmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + departmentId));
		return ApiResponse.builder().data(department).status(HttpStatus.OK).message(AppConstants.RETRIEVAL_SUCCESS)
				.success(Boolean.TRUE).errors(new ArrayList<>()).build();
	}

	@Transactional
	public Department deleteDepartment(UUID departmentId) {
		departmentRepository.deleteByUuid(departmentId);
		return null;
	}

	public Department addDepartment(DepartmentRequest department) {
		Department dept = Department.builder().departmentName(department.getDepartmentName())
				.description(department.getDescription()).build();
		return departmentRepository.save(dept);
	}
}
