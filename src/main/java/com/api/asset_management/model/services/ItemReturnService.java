package com.api.asset_management.model.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.asset_management.model.ItemReturn;
import com.api.asset_management.model.repository.ItemReturnRepository;

@Service
public class ItemReturnService {
	@Autowired
	private ItemReturnRepository itemReturnRepository;

	public List<ItemReturn> getAllItemReturn() {
		return itemReturnRepository.findAll();
	}

	public ItemReturn getItemReturnById(UUID itemReturnId) {
		return itemReturnRepository.findByUuid(itemReturnId);
	}

	public ItemReturn deleteItemReturn(UUID itemReturnId) {
		itemReturnRepository.deleteByUuid(itemReturnId);
		return null;
	}

	public void addItemReturn(ItemReturn itemReturn) {
		itemReturnRepository.save(itemReturn);
	}
}
