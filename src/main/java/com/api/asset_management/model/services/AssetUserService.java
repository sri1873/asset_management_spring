package com.api.asset_management.model.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.asset_management.model.AssetUser;
import com.api.asset_management.model.repository.AssetUserRepository;

@Service
public class AssetUserService {

	@Autowired
	private AssetUserRepository assetUserRepository;

	public List<AssetUser> getAllAssetUser() {
		return assetUserRepository.findAll();
	}

	public AssetUser getAssetUserById(UUID assetUserId) {
		return assetUserRepository.findByUuid(assetUserId);
	}

	public AssetUser deleteAssetUser(UUID assetUserId) {
		assetUserRepository.deleteByUuid(assetUserId);
		return null;
	}

	public void addAssetUser(AssetUser assetUser) {
		assetUserRepository.save(assetUser);
	}
}
