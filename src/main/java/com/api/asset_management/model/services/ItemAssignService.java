package com.api.asset_management.model.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.asset_management.model.ItemAssign;
import com.api.asset_management.model.repository.ItemAssignRepository;

@Service
public class ItemAssignService {
	@Autowired
	private ItemAssignRepository itemAssignRepository;

	public List<ItemAssign> getAllItemAssign() {
		return itemAssignRepository.findAll();
	}

	public ItemAssign getItemAssignById(UUID itemAssignId) {
		return itemAssignRepository.findByUuid(itemAssignId);
	}

	public ItemAssign deleteItemAssign(UUID itemAssignId) {
		itemAssignRepository.deleteByUuid(itemAssignId);
		return null;
	}

	public void addItemAssign(ItemAssign itemAssign) {
		itemAssignRepository.save(itemAssign);
	}
}
