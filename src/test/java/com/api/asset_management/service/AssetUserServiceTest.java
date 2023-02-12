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
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import com.api.asset_management.exception.ResourceNotFoundException;
import com.api.asset_management.model.AssetUser;
import com.api.asset_management.payload.ApiResponse;
import com.api.asset_management.repository.AssetUserRepository;
import com.api.asset_management.services.AssetUserService;

@ExtendWith(MockitoExtension.class)
class AssetUserServiceTest {
	@TestConfiguration
	static class AssetUserServiceImplTestContextConfiguration {

		@Bean
		public AssetUserService AssetUserService() {
			return new AssetUserService();
		}
	}

	@Mock
	private AssetUserRepository testRepo;
	@InjectMocks
	private AssetUserService testService;
	UUID id = UUID.randomUUID();
	AssetUser assetUser = AssetUser.builder().employee(null).name("SRI Kumar").password("123456789").userId(id)
			.username("srikumar").build();

	@Test
	void getAllAssetUserTest() {
		when(testRepo.findAll()).thenReturn(List.of(assetUser));
		ApiResponse result = testService.getAllAssetUser();
		Assert.assertEquals(result.getClass(), ApiResponse.class);
		Assert.assertNotNull(result.getData());
		Assert.assertEquals(HttpStatus.OK, result.getStatus());
		Assert.assertEquals(1, ((List<Object>) result.getData()).size());
	}

	@Test
	void getAssetUserByIdTest() {
		when(testRepo.findByUuid(id)).thenReturn(Optional.of(assetUser));
		ApiResponse result = testService.getAssetUserById(id);
		Assert.assertEquals(ApiResponse.class, result.getClass());
		Assert.assertNotNull(result.getData());
		AssetUser data = (AssetUser) result.getData();
		Assert.assertEquals(id, data.getUserId());
	}

	@Test
	void throwExceptionIfAssetUserIdNotPresentTest() {
		UUID id = UUID.randomUUID();
		Assert.assertThrows(ResourceNotFoundException.class, () -> {
			testService.getAssetUserById(id);
		});
	}

}
