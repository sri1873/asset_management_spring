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

import com.api.asset_management.model.AssetUser;
import com.api.asset_management.payload.ApiResponse;
import com.api.asset_management.payload.AssetUserRequest;
import com.api.asset_management.services.AssetUserService;

@RestController
public class AssetUserController {

	@Autowired
	private AssetUserService assetUserService;

	@GetMapping("/getAllAssetUser")
	public ResponseEntity<ApiResponse> getAllAssetUser() {
		ApiResponse users = assetUserService.getAllAssetUser();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/getAssetUserById/{assetUserId}")
	public ResponseEntity<ApiResponse> getAssetUserById(@PathVariable UUID assetUserId) {
		ApiResponse user = assetUserService.getAssetUserById(assetUserId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping("/changePassword/{assetUserId}")
	public ResponseEntity<AssetUser> changePassword(@PathVariable UUID assetUserId,
			@Valid @RequestBody AssetUserRequest assetUser) {
		AssetUser user = assetUserService.changePassword(assetUserId, assetUser);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteAssetUser/{user_id}")
	public AssetUser addAssetUser(@PathVariable UUID assetUserId) {
		return assetUserService.deleteAssetUser(assetUserId);
	}

}
