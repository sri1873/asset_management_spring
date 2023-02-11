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

import com.api.asset_management.model.Item;
import com.api.asset_management.payload.ApiResponse;
import com.api.asset_management.payload.ItemRequest;
import com.api.asset_management.services.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/getAllItem")
	public ResponseEntity<ApiResponse> getAllItem() {
		ApiResponse items = itemService.getAllItem();
		return new ResponseEntity<>(items, HttpStatus.OK);
	}

	@GetMapping("/getItemById/{itemId}")
	public ResponseEntity<ApiResponse> getItemById(@PathVariable UUID itemId) {
		ApiResponse item = itemService.getItemById(itemId);
		return new ResponseEntity<>(item, HttpStatus.OK);
	}

	@PostMapping("/addItem")
	public ResponseEntity<Item> addItem(@Valid @RequestBody ItemRequest item) {
		return new ResponseEntity<>(itemService.addItem(item), HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteItem/{itemId}")
	public Item addItem(@PathVariable UUID itemId) {
		return itemService.deleteItem(itemId);
	}
}
