package com.api.asset_management.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.asset_management.model.Item;
import com.api.asset_management.model.ItemAssign;
import com.api.asset_management.model.ItemReturn;
import com.api.asset_management.payload.ApiResponse;
import com.api.asset_management.payload.ItemReturnRequest;
import com.api.asset_management.repository.ItemAssignRepository;
import com.api.asset_management.repository.ItemRepository;
import com.api.asset_management.repository.ItemReturnRepository;
import com.api.asset_management.utils.AppConstants;

@Service
public class ItemReturnService {
	@Autowired
	private ItemReturnRepository itemReturnRepository;

	@Autowired
	private ItemAssignRepository itemAssignRepository;

	@Autowired
	private ItemRepository itemRepository;

	public ApiResponse getAllItemReturn() {
		List<ItemReturn> itms = itemReturnRepository.findAll();
		return ApiResponse.builder().data(itms).status(HttpStatus.OK).message(AppConstants.RETRIEVAL_SUCCESS)
				.success(Boolean.TRUE).errors(new ArrayList<>()).build();
	}

	public ApiResponse getItemReturnById(UUID itemReturnId) {
		ItemReturn itm = itemReturnRepository.findByUuid(itemReturnId);
		return ApiResponse.builder().data(itm).status(HttpStatus.OK).message(AppConstants.RETRIEVAL_SUCCESS)
				.success(Boolean.TRUE).errors(new ArrayList<>()).build();
	}

	@Transactional
	public ItemReturn deleteItemReturn(UUID itemReturnId) {
		itemReturnRepository.deleteByUuid(itemReturnId);
		return null;
	}

	public ItemReturn addItemReturn(ItemReturnRequest itemReturn) {
		Optional<Item> it = itemRepository.findByUuid(itemReturn.getItemId());
		Optional<ItemAssign> it2 = itemAssignRepository.findByUuid(itemReturn.getItemId());
		ItemReturn item = ItemReturn.builder().dateReturned(itemReturn.getDateReturned())
				.remarks(itemReturn.getRemarks()).status("RETURNED").condition(itemReturn.getCondition())
				.charges(itemReturn.getCharges()).item(it.get()).itemAssign(it2.get()).build();
		return itemReturnRepository.save(item);
	}
}
