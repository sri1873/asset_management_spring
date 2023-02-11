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
import com.api.asset_management.model.Employee;
import com.api.asset_management.model.Item;
import com.api.asset_management.model.ItemAssign;
import com.api.asset_management.payload.ApiResponse;
import com.api.asset_management.payload.ItemAssignRequest;
import com.api.asset_management.repository.EmployeeRepository;
import com.api.asset_management.repository.ItemAssignRepository;
import com.api.asset_management.repository.ItemRepository;
import com.api.asset_management.utils.AppConstants;

@Service
public class ItemAssignService {
	@Autowired
	private ItemAssignRepository itemAssignRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ItemRepository itemRepository;

	public ApiResponse getAllItemAssign() {
		List<ItemAssign> itms = itemAssignRepository.findAll();
		return ApiResponse.builder().data(itms).status(HttpStatus.OK).message(AppConstants.RETRIEVAL_SUCCESS)
				.success(Boolean.TRUE).errors(new ArrayList<>()).build();
	}

	public ApiResponse getItemAssignById(UUID itemAssignId) {
		ItemAssign itemAssign = itemAssignRepository.findByUuid(itemAssignId)
				.orElseThrow(() -> new ResourceNotFoundException("Assign item not found with id: " + itemAssignId));
		return ApiResponse.builder().data(itemAssign).status(HttpStatus.OK).message(AppConstants.RETRIEVAL_SUCCESS)
				.success(Boolean.TRUE).errors(new ArrayList<>()).build();
	}

	@Transactional
	public ItemAssign deleteItemAssign(UUID itemAssignId) {
		itemAssignRepository.deleteByUuid(itemAssignId);
		return null;
	}

	public ItemAssign addItemAssign(ItemAssignRequest itemAssign) {
		Optional<Employee> emp = employeeRepository.findById(itemAssign.getEmployeeId());
		Optional<Item> it = itemRepository.findByUuid(itemAssign.getItemId());

		ItemAssign item = ItemAssign.builder().dateAssigned(itemAssign.getDateAssigned())
				.remarks(itemAssign.getRemarks()).employee(emp.get()).item(it.get()).build();
		return itemAssignRepository.save(item);
	}
}
