package com.api.asset_management.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.asset_management.model.ItemAssign;

@Repository
public interface ItemAssignRepository extends JpaRepository<ItemAssign, UUID> {
	@Query(value = "SELECT * FROM item_assign i where i.assignment_id =?1", nativeQuery = true)
	Optional<ItemAssign> findByUuid(UUID branchId);

	@Modifying
	@Query(value = "DELETE FROM item_assign i where i.assignment_id =?1", nativeQuery = true)
	void deleteByUuid(UUID branchId);
}
