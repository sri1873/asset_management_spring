package com.api.asset_management.model.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.asset_management.model.Item;
import com.api.asset_management.model.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public List<Item> getAllItem() {
		return itemRepository.findAll();
	}

	public Item getItemById(UUID itemId) {
		return itemRepository.findByUuid(itemId);
	}

	public Item deleteItem(UUID itemId) {
		itemRepository.deleteByUuid(itemId);
		return null;
	}

	public void addItem(Item item) {
		itemRepository.save(item);
	}
}
