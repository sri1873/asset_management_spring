package com.api.asset_management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.asset_management.model.AssetUser;
import com.api.asset_management.model.Branch;
import com.api.asset_management.model.Department;
import com.api.asset_management.model.Employee;
import com.api.asset_management.model.Item;
import com.api.asset_management.payload.EmployeeRequest;
import com.api.asset_management.repository.AssetUserRepository;
import com.api.asset_management.repository.BranchRepository;
import com.api.asset_management.repository.DepartmentRepository;
import com.api.asset_management.repository.EmployeeRepository;

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

	public List<Employee> getAllEmployee() {
		return employeeRepository.getAllemps();
	}

	public Employee getAllEmployeeById(String employeeId) {
		Optional<Employee> emp = employeeRepository.findById(employeeId);
		if (emp.isEmpty())
			return null;
		return emp.get();
	}

	@Transactional
	public Employee deleteEmployee(String employeeId) {
		employeeRepository.deleteByEmployeeId(employeeId);
		return null;
	}

	public void addEmployee(EmployeeRequest emp) {
		Department dept = departmentRepository.findByUuid(emp.getDepartmentId());
		Branch branch = branchRepository.findByUuid(emp.getBranchId());

		AssetUser user = AssetUser.builder().name(emp.getFirstName() + emp.getLastName()).username(emp.getEmail())
				.password(emp.getPassword()).build();
		assetUserRepository.save(user);

		Employee emp1 = Employee.builder().employeeId(emp.getEmployeeId()).firstName(emp.getFirstName())
				.lastName(emp.getLastName()).phoneNumber(emp.getPhoneNumber()).email(emp.getEmail()).department(dept)
				.branch(branch).status("ACTIVE").user(user).build();

		employeeRepository.save(emp1);
	}

	public Item getAllAssignedItems(String employeeId) {
		return employeeRepository.assignedItems(employeeId);
	}
}
