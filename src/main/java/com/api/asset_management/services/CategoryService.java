package com.api.asset_management.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.asset_management.model.Category;
import com.api.asset_management.payload.CategoryRequest;
import com.api.asset_management.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	public Category getCategoryById(UUID categoryId) {
		return categoryRepository.findByUuid(categoryId);
	}

	@Transactional
	public void deleteCategory(UUID categoryId) {
		categoryRepository.deleteByUuid(categoryId);
	}

	public void addCategory(CategoryRequest category) {
		Category cat = Category.builder().categoryName(category.getCategoryName())
				.description(category.getDescription()).build();
		categoryRepository.save(cat);
	}
}
