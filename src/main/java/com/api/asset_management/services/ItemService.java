package com.api.asset_management.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.asset_management.model.Category;
import com.api.asset_management.model.Item;
import com.api.asset_management.payload.ItemRequest;
import com.api.asset_management.repository.CategoryRepository;
import com.api.asset_management.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	private CategoryRepository categoryRepository;

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

	public void addItem(ItemRequest item) {
		Category cat = categoryRepository.findByUuid(item.getCategoryId());
		Item item1 = Item.builder().datePurchased(item.getDatePurchased()).price(item.getPrice())
				.itemName(item.getItemName()).serialNumber(item.getSerialNumber()).status("UNASSIGNED").category(cat)
				.build();
		itemRepository.save(item1);
	}
}
