package com.api.asset_management.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.asset_management.model.AssetUser;
import com.api.asset_management.payload.AssetUserRequest;
import com.api.asset_management.services.AssetUserService;

@RestController
public class AssetUserController {

	@Autowired
	private AssetUserService assetUserService;

	@GetMapping("/getAllAssetUser")
	public List<AssetUser> getAllAssetUser() {
		return assetUserService.getAllAssetUser();
	}

	@GetMapping("/getAssetUserById/{assetUserId}")
	public AssetUser getAssetUserById(@PathVariable UUID assetUserId) {
		return assetUserService.getAssetUserById(assetUserId);
	}

	@PostMapping("/changePassword/{assetUserId}")
	public void changePassword(@PathVariable UUID assetUserId, @Valid @RequestBody AssetUserRequest assetUser) {
		assetUserService.changePassword(assetUserId, assetUser);
	}

	@DeleteMapping("/deleteAssetUser/{user_id}")
	public AssetUser addAssetUser(@PathVariable UUID assetUserId) {
		return assetUserService.deleteAssetUser(assetUserId);
	}

}
