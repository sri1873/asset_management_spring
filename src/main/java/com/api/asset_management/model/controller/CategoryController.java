package com.api.asset_management.model.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.asset_management.model.Category;
import com.api.asset_management.model.services.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/getAllCategory")
	public List<Category> getAllCategory() {
		return categoryService.getAllCategory();
	}

	@GetMapping("/getCategoryById/{category_id}")
	public Category getCategoryById(@PathVariable UUID categoryId) {
		return categoryService.getCategoryById(categoryId);
	}

	@PostMapping("/addCategory")
	public void addCategory(@RequestBody Category category) {
		categoryService.addCategory(category);
	}

	@DeleteMapping("/deleteCategory/{category_id}")
	public Category deleteCategory(@PathVariable UUID categoryId) {
		return categoryService.deleteCategory(categoryId);
	}
}
