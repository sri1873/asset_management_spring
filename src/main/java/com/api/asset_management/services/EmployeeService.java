package com.api.asset_management.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.asset_management.exception.ResourceNotFoundException;
import com.api.asset_management.model.AssetUser;
import com.api.asset_management.model.Branch;
import com.api.asset_management.model.Department;
import com.api.asset_management.model.Employee;
import com.api.asset_management.model.Item;
import com.api.asset_management.payload.ApiResponse;
import com.api.asset_management.payload.EmployeeRequest;
import com.api.asset_management.repository.AssetUserRepository;
import com.api.asset_management.repository.BranchRepository;
import com.api.asset_management.repository.DepartmentRepository;
import com.api.asset_management.repository.EmployeeRepository;
import com.api.asset_management.utils.AppConstants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
@Builder
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private AssetUserRepository assetUserRepository;

	public ApiResponse getAllEmployee() {
		List<Employee> emps = employeeRepository.getAllemps();
		return ApiResponse.builder().data(emps).status(HttpStatus.OK).message(AppConstants.RETRIEVAL_SUCCESS)
				.success(Boolean.TRUE).errors(new ArrayList<>()).build();
	}

	public ApiResponse getAllEmployeeById(String employeeId) {
		Employee emp = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));

		return ApiResponse.builder().data(emp).status(HttpStatus.OK).message(AppConstants.RETRIEVAL_SUCCESS)
				.success(Boolean.TRUE).errors(new ArrayList<>()).build();
	}

	@Transactional
	public Employee deleteEmployee(String employeeId) {
		employeeRepository.deleteByEmployeeId(employeeId);
		return null;
	}

	public Employee addEmployee(EmployeeRequest emp) {
		Optional<Department> dept = departmentRepository.findByUuid(emp.getDepartmentId());
		Optional<Branch> branch = branchRepository.findByUuid(emp.getBranchId());

		AssetUser user = AssetUser.builder().name(emp.getFirstName() + emp.getLastName()).username(emp.getEmail())
				.password(emp.getPassword()).build();
		assetUserRepository.save(user);

		Employee emp1 = Employee.builder().employeeId(emp.getEmployeeId()).firstName(emp.getFirstName())
				.lastName(emp.getLastName()).phoneNumber(emp.getPhoneNumber()).email(emp.getEmail())
				.department(dept.get()).branch(branch.get()).status("ACTIVE").user(user).build();

		return employeeRepository.save(emp1);
	}

	public ApiResponse getAllAssignedItems(String employeeId) {
		List<Item> itms = employeeRepository.assignedItems(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));
		;
		return ApiResponse.builder().data(itms).status(HttpStatus.OK).message(AppConstants.RETRIEVAL_SUCCESS)
				.success(Boolean.TRUE).errors(new ArrayList<>()).build();
	}
}
