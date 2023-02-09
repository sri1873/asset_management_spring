package com.api.asset_management.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.asset_management.model.Employee;
import com.api.asset_management.model.Item;
import com.api.asset_management.model.ItemAssign;
import com.api.asset_management.payload.ItemAssignRequest;
import com.api.asset_management.repository.EmployeeRepository;
import com.api.asset_management.repository.ItemAssignRepository;
import com.api.asset_management.repository.ItemRepository;

@Service
public class ItemAssignService {
	@Autowired
	private ItemAssignRepository itemAssignRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ItemRepository itemRepository;

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

	public void addItemAssign(ItemAssignRequest itemAssign) {
		Optional<Employee> emp = employeeRepository.findById(itemAssign.getEmployeeId());
		Item it = itemRepository.findByUuid(itemAssign.getItemId());

		ItemAssign item = ItemAssign.builder().dateAssigned(itemAssign.getDateAssigned())
				.remarks(itemAssign.getRemarks()).employee(emp.get()).item(it).build();
		itemAssignRepository.save(item);
	}
}
