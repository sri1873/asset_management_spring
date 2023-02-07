package com.api.asset_management.model.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.asset_management.model.Category;
import com.api.asset_management.model.repository.CategoryRepository;

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

	public Category deleteCategory(UUID categoryId) {
		categoryRepository.deleteByUuid(categoryId);
		return null;
	}

	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
}
