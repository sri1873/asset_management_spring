package com.api.asset_management.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.asset_management.exception.ResourceNotFoundException;
import com.api.asset_management.model.AssetUser;
import com.api.asset_management.payload.ApiResponse;
import com.api.asset_management.payload.AssetUserRequest;
import com.api.asset_management.repository.AssetUserRepository;
import com.api.asset_management.utils.AppConstants;

@Service
public class AssetUserService {

	@Autowired
	private AssetUserRepository assetUserRepository;

	public ApiResponse getAllAssetUser() {
		List<AssetUser> users = assetUserRepository.findAll();
		return ApiResponse.builder().data(users).status(HttpStatus.OK).message(AppConstants.RETRIEVAL_SUCCESS)
				.success(Boolean.TRUE).errors(new ArrayList<>()).build();
	}

	public ApiResponse getAssetUserById(UUID assetUserId) {
		AssetUser user = assetUserRepository.findByUuid(assetUserId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + assetUserId));
		return ApiResponse.builder().data(user).status(HttpStatus.OK).message(AppConstants.RETRIEVAL_SUCCESS)
				.success(Boolean.TRUE).errors(new ArrayList<>()).build();
	}

	@Transactional
	public AssetUser deleteAssetUser(UUID assetUserId) {
		assetUserRepository.deleteByUuid(assetUserId);
		return null;
	}

	public AssetUser changePassword(UUID assetUserId, AssetUserRequest assetUser) {
		AssetUser user = assetUserRepository.findByUuid(assetUserId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + assetUserId));
		user.setPassword(assetUser.getPassword());
		return user;
	}
}
