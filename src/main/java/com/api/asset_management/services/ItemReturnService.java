package com.api.asset_management.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.asset_management.model.Item;
import com.api.asset_management.model.ItemAssign;
import com.api.asset_management.model.ItemReturn;
import com.api.asset_management.payload.ItemReturnRequest;
import com.api.asset_management.repository.ItemAssignRepository;
import com.api.asset_management.repository.ItemRepository;
import com.api.asset_management.repository.ItemReturnRepository;

@Service
public class ItemReturnService {
	@Autowired
	private ItemReturnRepository itemReturnRepository;

	@Autowired
	private ItemAssignRepository itemAssignRepository;

	@Autowired
	private ItemRepository itemRepository;

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

	public void addItemReturn(ItemReturnRequest itemReturn) {
		Item it = itemRepository.findByUuid(itemReturn.getItemId());
		ItemAssign it2 = itemAssignRepository.findByUuid(itemReturn.getItemId());
		ItemReturn item = ItemReturn.builder().dateReturned(itemReturn.getDateReturned())
				.remarks(itemReturn.getRemarks()).status("RETURNED").condition(itemReturn.getCondition())
				.charges(itemReturn.getCharges()).item(it).itemAssign(it2).build();
		itemReturnRepository.save(item);
	}
}
