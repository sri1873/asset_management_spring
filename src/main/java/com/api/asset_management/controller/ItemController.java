package com.api.asset_management.model.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.asset_management.model.Item;
import com.api.asset_management.model.services.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/getAllItem")
	public List<Item> getAllItem() {
		return itemService.getAllItem();
	}

	@GetMapping("/getItemById/{item_id}")
	public Item getItemById(@PathVariable UUID itemId) {
		return itemService.getItemById(itemId);
	}

	@PostMapping("/addItem")
	public void addItem(@RequestBody Item item) {
		itemService.addItem(item);
	}

	@DeleteMapping("/deleteItem/{item_id}")
	public Item addItem(@PathVariable UUID itemId) {
		return itemService.deleteItem(itemId);
	}
}
