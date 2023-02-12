package com.api.asset_management.service;

import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import com.api.asset_management.exception.ResourceNotFoundException;
import com.api.asset_management.model.Category;
import com.api.asset_management.payload.ApiResponse;
import com.api.asset_management.payload.CategoryRequest;
import com.api.asset_management.repository.CategoryRepository;
import com.api.asset_management.services.CategoryService;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {
	@TestConfiguration
	static class CategoryServiceImplTestContextConfiguration {

		@Bean
		public CategoryService categoryService() {
			return new CategoryService();
		}
	}

	@Mock
	private CategoryRepository testRepo;
	@InjectMocks
	private CategoryService testService;
	UUID id = UUID.randomUUID();
	Category cat = Category.builder().categoryName("laptops").categoryId(id).description("description").item(null)
			.build();

	@Test
	void getAllCategoryTest() {
		when(testRepo.findAll()).thenReturn(List.of(cat));
		ApiResponse result = testService.getAllCategory();
		Assert.assertEquals(result.getClass(), ApiResponse.class);
		Assert.assertNotNull(result.getData());
		Assert.assertEquals(HttpStatus.OK, result.getStatus());
		Assert.assertEquals(1, ((List<Object>) result.getData()).size());
	}

	@Test
	void getCategoryByIdTest() {
		when(testRepo.findByUuid(id)).thenReturn(Optional.of(cat));
		ApiResponse result = testService.getCategoryById(id);
		Assert.assertEquals(ApiResponse.class, result.getClass());
		Assert.assertNotNull(result.getData());
		Category data = (Category) result.getData();
		Assert.assertEquals(id, data.getCategoryId());
	}

	@Test
	void throwExceptionIfCategoryIdNotPresentTest() {
		UUID id = UUID.randomUUID();
		Assert.assertThrows(ResourceNotFoundException.class, () -> {
			testService.getCategoryById(id);
		});
	}

	@Test
	void addCategoryTest() {
		when(testRepo.save(Mockito.any(Category.class))).thenReturn(cat);
		Category result = testService
				.addCategory(CategoryRequest.builder().categoryName("laptops").description("description").build());
		Assert.assertNotNull(result);
		Assert.assertEquals("laptops", result.getCategoryName());

	}

}
