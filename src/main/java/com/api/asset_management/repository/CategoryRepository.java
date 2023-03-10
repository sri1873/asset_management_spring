package com.api.asset_management.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.asset_management.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
	@Query(value = "SELECT * FROM category c where c.category_id =?1", nativeQuery = true)
	Optional<Category> findByUuid(UUID categoryId);

	@Modifying
	@Query(value = "DELETE FROM category c where c.category_id =?1", nativeQuery = true)
	void deleteByUuid(UUID categoryId);
}
