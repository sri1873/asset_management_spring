package com.api.asset_management.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.asset_management.model.ItemAssign;
import com.api.asset_management.payload.ItemAssignRequest;
import com.api.asset_management.services.ItemAssignService;

@RestController
public class ItemAssignController {
	@Autowired
	private ItemAssignService itemAssignService;

	@GetMapping("/getAllItemAssign")
	public List<ItemAssign> getAllItemAssign() {
		return itemAssignService.getAllItemAssign();
	}

	@GetMapping("/getItemAssignById/{itemAssignId}")
	public ItemAssign getItemAssignById(@PathVariable UUID itemAssignId) {
		return itemAssignService.getItemAssignById(itemAssignId);
	}

	@PostMapping("/addItemAssign")
	public void addItemAssign(@Valid @RequestBody ItemAssignRequest itemAssign) {
		itemAssignService.addItemAssign(itemAssign);
	}

	@DeleteMapping("/deleteItemAssign/{itemAssignId}")
	public ItemAssign addItemAssign(@PathVariable UUID itemAssignId) {
		return itemAssignService.deleteItemAssign(itemAssignId);
	}
}
