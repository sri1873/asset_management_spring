package com.api.asset_management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.asset_management.model.Employee;
import com.api.asset_management.model.Item;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
	@Query(value = "SELECT * FROM public.employee e where  e.employee_id = ?1", nativeQuery = true)
	Optional<Employee> getAllempsbyId(String employeeId);

	@Query(value = "SELECT * FROM public.employee", nativeQuery = true)
	List<Employee> getAllemps();

	@Query(value = "DELETE FROM employee e where e.employee_id = ?1", nativeQuery = true)
	void deleteByEmployeeId(String employeeId);

	@Modifying
	@Query(value = "Select * from item_assign i  join item j on i.item_id = j.item_id where i.employee_id = ?1", nativeQuery = true)
	Optional<List<Item>> assignedItems(String employeeId);
}
