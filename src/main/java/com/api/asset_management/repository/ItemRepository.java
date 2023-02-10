package com.api.asset_management.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.asset_management.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

	@Query(value = "SELECT * FROM item i where i.item_id =?1", nativeQuery = true)
	Item findByUuid(UUID itemId);

	@Modifying
	@Query(value = "DELETE FROM item i where i.item_id =?1", nativeQuery = true)
	void deleteByUuid(UUID itemId);
}
