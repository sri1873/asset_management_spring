package com.api.asset_management.model.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.asset_management.model.Department;
import com.api.asset_management.model.repository.DepartmentRepository;

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

	public Department deleteDepartment(UUID departmentId) {
		departmentRepository.deleteByUuid(departmentId);
		return null;
	}

	public void addDepartment(Department department) {
		departmentRepository.save(department);
	}
}
