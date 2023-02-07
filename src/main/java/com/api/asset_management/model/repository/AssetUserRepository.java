package com.api.asset_management.model.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.asset_management.model.AssetUser;

@Repository
public interface AssetUserRepository extends JpaRepository<AssetUser, UUID> {
	@Query(value = "SELECT * FROM asset_user a where a.user_id ==?1", nativeQuery = true)
	AssetUser findByUuid(UUID userId);

	@Query(value = "DELETE FROM asset_user a where a.user_id ==?1", nativeQuery = true)
	void deleteByUuid(UUID userId);
}
