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
import com.api.asset_management.model.Department;
import com.api.asset_management.payload.ApiResponse;
import com.api.asset_management.payload.DepartmentRequest;
import com.api.asset_management.repository.DepartmentRepository;
import com.api.asset_management.services.DepartmentService;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
	@TestConfiguration
	static class DepartmentServiceImplTestContextConfiguration {

		@Bean
		public DepartmentService departmentService() {
			return new DepartmentService();
		}
	}

	@Mock
	private DepartmentRepository testRepo;
	@InjectMocks
	private DepartmentService testService;
	UUID id = UUID.randomUUID();
	Department dept = Department.builder().departmentName("Testing").departmentId(id).description("description")
			.employee(null).build();

	@Test
	void getAllDepartmentTest() {
		when(testRepo.findAll()).thenReturn(List.of(dept));
		ApiResponse result = testService.getAllDepartment();
		Assert.assertEquals(result.getClass(), ApiResponse.class);
		Assert.assertNotNull(result.getData());
		Assert.assertEquals(HttpStatus.OK, result.getStatus());
		Assert.assertEquals(1, ((List<Object>) result.getData()).size());
	}

	@Test
	void getDepartmentByIdTest() {
		when(testRepo.findByUuid(id)).thenReturn(Optional.of(dept));
		ApiResponse result = testService.getDepartmentById(id);
		Assert.assertEquals(ApiResponse.class, result.getClass());
		Assert.assertNotNull(result.getData());
		Department data = (Department) result.getData();
		Assert.assertEquals(id, data.getDepartmentId());
	}

	@Test
	void throwExceptionIfDepartmentIdNotPresentTest() {
		UUID id = UUID.randomUUID();
		Assert.assertThrows(ResourceNotFoundException.class, () -> {
			testService.getDepartmentById(id);
		});
	}

	@Test
	void addDepartmentTest() {
		when(testRepo.save(Mockito.any(Department.class))).thenReturn(dept);
		Department result = testService.addDepartment(
				DepartmentRequest.builder().departmentName("Testing").description("description").build());
		Assert.assertNotNull(result);
		Assert.assertEquals("Testing", result.getDepartmentName());

	}

}
