package com.api.asset_management.model.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.asset_management.model.ItemAssign;

@Repository
public interface ItemAssignRepository extends JpaRepository<ItemAssign, UUID> {
	@Query(value = "SELECT * FROM item_assign i where i.assignment_id ==?1", nativeQuery = true)
	ItemAssign findByUuid(UUID branchId);

	@Query(value = "DELETE FROM item_assign i where i.assignment_id", nativeQuery = true)
	void deleteByUuid(UUID branchId);
}
