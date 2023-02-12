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
import com.api.asset_management.model.Branch;
import com.api.asset_management.payload.ApiResponse;
import com.api.asset_management.payload.BranchRequest;
import com.api.asset_management.repository.BranchRepository;
import com.api.asset_management.services.BranchService;

@ExtendWith(MockitoExtension.class)
class BranchServiceTest {
	@TestConfiguration
	static class BranchServiceImplTestContextConfiguration {

		@Bean
		public BranchService branchService() {
			return new BranchService();
		}
	}

	@Mock
	private BranchRepository testRepo;
	@InjectMocks
	private BranchService testService;
	UUID id = UUID.randomUUID();
	Branch branch = Branch.builder().branchId(id).contact(6309557701l).location("Hyderabad").employee(null).build();

	@Test
	void getAllBranchTest() {
		when(testRepo.findAll()).thenReturn(List.of(branch));
		ApiResponse result = testService.getAllBranch();
		Assert.assertEquals(result.getClass(), ApiResponse.class);
		Assert.assertNotNull(result.getData());
		Assert.assertEquals(HttpStatus.OK, result.getStatus());
		Assert.assertEquals(1, ((List<Object>) result.getData()).size());
	}

	@Test
	void getBranchByIdTest() {
		when(testRepo.findByUuid(id)).thenReturn(Optional.of(branch));
		ApiResponse result = testService.getBranchById(id);
		Assert.assertEquals(ApiResponse.class, result.getClass());
		Assert.assertNotNull(result.getData());
		Branch data = (Branch) result.getData();
		Assert.assertEquals(id, data.getBranchId());
	}

	@Test
	void throwExceptionIfBranchIdNotPresentTest() {
		UUID id = UUID.randomUUID();
		Assert.assertThrows(ResourceNotFoundException.class, () -> {
			testService.getBranchById(id);
		});
	}

	@Test
	void addBranchTest() {
		when(testRepo.save(Mockito.any(Branch.class))).thenReturn(branch);
		Branch result = testService
				.addBranch(BranchRequest.builder().location("Hyderabad").contact(6309557701l).build());
		Assert.assertNotNull(result);
		Assert.assertEquals("Hyderabad", result.getLocation());

	}
}
