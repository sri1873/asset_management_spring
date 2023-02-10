package com.api.asset_management.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.asset_management.model.ItemReturn;

@Repository
public interface ItemReturnRepository extends JpaRepository<ItemReturn, UUID> {
	@Query(value = "SELECT * FROM item_return r where r.retrival_id =?1", nativeQuery = true)
	ItemReturn findByUuid(UUID itemId);

	@Modifying
	@Query(value = "DELETE FROM  item_return r where r.retrival_id =?1", nativeQuery = true)
	void deleteByUuid(UUID itemId);
}
