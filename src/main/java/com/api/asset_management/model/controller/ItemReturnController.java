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

import com.api.asset_management.model.ItemReturn;
import com.api.asset_management.model.services.ItemReturnService;

@RestController
public class ItemReturnController {

	@Autowired
	private ItemReturnService itemReturnService;

	@GetMapping("/getAllItemReturn")
	public List<ItemReturn> getAllItemReturn() {
		return itemReturnService.getAllItemReturn();
	}

	@GetMapping("/getItemReturnById/{ItemReturn_id}")
	public ItemReturn getItemReturnById(@PathVariable UUID itemReturnId) {
		return itemReturnService.getItemReturnById(itemReturnId);
	}

	@PostMapping("/addItemReturn")
	public void addItemReturn(@RequestBody ItemReturn itemReturn) {
		itemReturnService.addItemReturn(itemReturn);
	}

	@DeleteMapping("/deleteItemReturn/{ItemReturn_id}")
	public ItemReturn addItemReturn(@PathVariable UUID itemReturnId) {
		return itemReturnService.deleteItemReturn(itemReturnId);
	}
}
