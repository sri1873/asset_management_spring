package com.api.asset_management.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.asset_management.model.ItemAssign;
import com.api.asset_management.payload.ApiResponse;
import com.api.asset_management.payload.ItemAssignRequest;
import com.api.asset_management.services.ItemAssignService;

@RestController
public class ItemAssignController {
	@Autowired
	private ItemAssignService itemAssignService;

	@GetMapping("/getAllItemAssign")
	public ResponseEntity<ApiResponse> getAllItemAssign() {
		return new ResponseEntity<>(itemAssignService.getAllItemAssign(), HttpStatus.OK);
	}

	@GetMapping("/getItemAssignById/{itemAssignId}")
	public ResponseEntity<ApiResponse> getItemAssignById(@PathVariable UUID itemAssignId) {
		return new ResponseEntity<>(itemAssignService.getItemAssignById(itemAssignId), HttpStatus.OK);
	}

	@PostMapping("/addItemAssign")
	public ResponseEntity<ItemAssign> addItemAssign(@Valid @RequestBody ItemAssignRequest itemAssign) {
		return new ResponseEntity<>(itemAssignService.addItemAssign(itemAssign), HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteItemAssign/{itemAssignId}")
	public ItemAssign addItemAssign(@PathVariable UUID itemAssignId) {
		return itemAssignService.deleteItemAssign(itemAssignId);
	}
}
