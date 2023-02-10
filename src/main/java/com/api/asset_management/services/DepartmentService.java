package com.api.asset_management.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.asset_management.model.Department;
import com.api.asset_management.payload.DepartmentRequest;
import com.api.asset_management.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public List<Department> getAllDepartment() {
		return departmentRepository.findAll();
	}

	public Department getDepartmentById(UUID departmentId) {
		return departmentRepository.findByUuid(departmentId);
	}

	@Transactional
	public Department deleteDepartment(UUID departmentId) {
		departmentRepository.deleteByUuid(departmentId);
		return null;
	}

	public void addDepartment(DepartmentRequest department) {
		Department dept = Department.builder().departmentName(department.getDepartmentName())
				.description(department.getDescription()).build();
		departmentRepository.save(dept);
	}
}
