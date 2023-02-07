package com.api.asset_management.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.asset_management.model.Employee;
import com.api.asset_management.model.Item;
import com.api.asset_management.model.repository.EmployeeRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	public Employee getAllEmployeeById(String employeeId) {
		Optional<Employee> emp = employeeRepository.findById(employeeId);
		if (emp.isEmpty())
			return null;
		return emp.get();
	}

	public Employee deleteEmployee(String employeeId) {
		employeeRepository.deleteByEmployeeId(employeeId);
		return null;
	}

	public void addEmployee(Employee emp) {
		employeeRepository.save(emp);
	}

	public Item getAllAssignedItems(String employeeId) {
		return employeeRepository.assignedItems(employeeId);
	}
}
