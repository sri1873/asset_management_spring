package com.api.asset_management.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.asset_management.model.Category;
import com.api.asset_management.payload.ApiResponse;
import com.api.asset_management.payload.CategoryRequest;
import com.api.asset_management.services.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/getAllCategory")
	public ResponseEntity<ApiResponse> getAllCategory() {
		ApiResponse categories = categoryService.getAllCategory();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

	@GetMapping("/getCategoryById/{categoryId}")
	public ResponseEntity<ApiResponse> getCategoryById(@PathVariable UUID categoryId) {
		ApiResponse category = categoryService.getCategoryById(categoryId);
		return new ResponseEntity<>(category, HttpStatus.OK);
	}

	@PostMapping("/addCategory")
	public ResponseEntity<Category> addCategory(@Valid @RequestBody CategoryRequest category) {
		return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.OK);
	}

	@DeleteMapping("/deleteCategory/{categoryId}")
	public void deleteCategory(@PathVariable UUID categoryId) {
		categoryService.deleteCategory(categoryId);
	}
}
