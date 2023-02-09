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

import com.api.asset_management.model.ItemReturn;
import com.api.asset_management.payload.ItemReturnRequest;
import com.api.asset_management.services.ItemReturnService;

@RestController
public class ItemReturnController {

	@Autowired
	private ItemReturnService itemReturnService;

	@GetMapping("/getAllItemReturn")
	public List<ItemReturn> getAllItemReturn() {
		return itemReturnService.getAllItemReturn();
	}

	@GetMapping("/getItemReturnById/{itemReturnId}")
	public ItemReturn getItemReturnById(@PathVariable UUID itemReturnId) {
		return itemReturnService.getItemReturnById(itemReturnId);
	}

	@PostMapping("/addItemReturn")
	public void addItemReturn(@Valid @RequestBody ItemReturnRequest itemReturn) {
		itemReturnService.addItemReturn(itemReturn);
	}

	@DeleteMapping("/deleteItemReturn/{itemReturnId}")
	public ItemReturn addItemReturn(@PathVariable UUID itemReturnId) {
		return itemReturnService.deleteItemReturn(itemReturnId);
	}
}
