package com.api.asset_management.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.asset_management.exception.ResourceNotFoundException;
import com.api.asset_management.model.Category;
import com.api.asset_management.payload.ApiResponse;
import com.api.asset_management.payload.CategoryRequest;
import com.api.asset_management.repository.CategoryRepository;
import com.api.asset_management.utils.AppConstants;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public ApiResponse getAllCategory() {
		List<Category> cats = categoryRepository.findAll();
		return ApiResponse.builder().data(cats).status(HttpStatus.OK).message(AppConstants.RETRIEVAL_SUCCESS)
				.success(Boolean.TRUE).errors(new ArrayList<>()).build();
	}

	public ApiResponse getCategoryById(UUID categoryId) {
		Category cat = categoryRepository.findByUuid(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + categoryId));
		return ApiResponse.builder().data(cat).status(HttpStatus.OK).message(AppConstants.RETRIEVAL_SUCCESS)
				.success(Boolean.TRUE).errors(new ArrayList<>()).build();
	}

	@Transactional
	public void deleteCategory(UUID categoryId) {
		categoryRepository.deleteByUuid(categoryId);
	}

	public Category addCategory(CategoryRequest category) {
		Category cat = Category.builder().categoryName(category.getCategoryName())
				.description(category.getDescription()).build();
		return categoryRepository.save(cat);
	}
}
