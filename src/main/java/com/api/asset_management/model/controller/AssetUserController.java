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

import com.api.asset_management.model.AssetUser;
import com.api.asset_management.model.services.AssetUserService;

@RestController
public class AssetUserController {

	@Autowired
	private AssetUserService assetUserService;

	@GetMapping("/getAllAssetUser")
	public List<AssetUser> getAllAssetUser() {
		return assetUserService.getAllAssetUser();
	}

	@GetMapping("/getAssetUserById/{user_id}")
	public AssetUser getAssetUserById(@PathVariable UUID assetUserId) {
		return assetUserService.getAssetUserById(assetUserId);
	}

	@PostMapping("/addAssetUser")
	public void addAssetUser(@RequestBody AssetUser assetUser) {
		assetUserService.addAssetUser(assetUser);
	}

	@DeleteMapping("/deleteAssetUser/{user_id}")
	public AssetUser addAssetUser(@PathVariable UUID assetUserId) {
		return assetUserService.deleteAssetUser(assetUserId);
	}

}
