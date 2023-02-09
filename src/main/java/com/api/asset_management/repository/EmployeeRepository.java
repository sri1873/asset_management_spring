package com.api.asset_management.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.asset_management.model.Employee;
import com.api.asset_management.model.Item;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
	@Query(value = "DELETE FROM employee e where e.employee_id == ?1", nativeQuery = true)
	void deleteByEmployeeId(String employeeId);

	@Query(value = "Select * from item_assign i  join item j on i.item_id = j.item_id where i.employee_id = ?1", nativeQuery = true)
	Item assignedItems(String employeeId);
}
