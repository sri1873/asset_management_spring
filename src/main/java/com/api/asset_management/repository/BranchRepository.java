package com.api.asset_management.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.asset_management.model.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, UUID> {
	@Query(value = "SELECT * FROM branch b where b.branch_id =?1", nativeQuery = true)
	Branch findByUuid(UUID branchId);

	@Modifying
	@Query(value = "DELETE FROM branch b where b.branch_id =?1", nativeQuery = true)
	void deleteByUuid(UUID branchId);
}
