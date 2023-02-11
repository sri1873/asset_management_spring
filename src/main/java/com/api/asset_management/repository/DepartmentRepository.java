package com.api.asset_management.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.asset_management.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {
	@Query(value = "SELECT * FROM department d where d.department_id =?1", nativeQuery = true)
	Optional<Department> findByUuid(UUID departmentId);

	@Modifying
	@Query(value = "DELETE FROM department d where d.department_id =?1", nativeQuery = true)
	void deleteByUuid(UUID departmentId);
}
