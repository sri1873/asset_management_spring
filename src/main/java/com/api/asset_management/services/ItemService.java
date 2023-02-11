package com.api.asset_management.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.asset_management.exception.ResourceNotFoundException;
import com.api.asset_management.model.Category;
import com.api.asset_management.model.Item;
import com.api.asset_management.payload.ApiResponse;
import com.api.asset_management.payload.ItemRequest;
import com.api.asset_management.repository.CategoryRepository;
import com.api.asset_management.repository.ItemRepository;
import com.api.asset_management.utils.AppConstants;

@Service
public class ItemService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ItemRepository itemRepository;

	public ApiResponse getAllItem() {
		List<Item> items = itemRepository.findAll();
		return ApiResponse.builder().data(items).status(HttpStatus.OK).message(AppConstants.RETRIEVAL_SUCCESS)
				.success(Boolean.TRUE).errors(new ArrayList<>()).build();
	}

	public ApiResponse getItemById(UUID itemId) {
		Item item = itemRepository.findByUuid(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + itemId));
		return ApiResponse.builder().data(item).status(HttpStatus.OK).message(AppConstants.RETRIEVAL_SUCCESS)
				.success(Boolean.TRUE).errors(new ArrayList<>()).build();
	}

	@Transactional
	public Item deleteItem(UUID itemId) {
		itemRepository.deleteByUuid(itemId);
		return null;
	}

	public Item addItem(ItemRequest item) {
		Optional<Category> cat = categoryRepository.findByUuid(item.getCategoryId());
		Item item1 = Item.builder().datePurchased(item.getDatePurchased()).price(item.getPrice())
				.itemName(item.getItemName()).serialNumber(item.getSerialNumber()).status("UNASSIGNED")
				.category(cat.get()).build();
		return itemRepository.save(item1);
	}
}
