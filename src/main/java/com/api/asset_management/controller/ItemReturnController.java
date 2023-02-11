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

import com.api.asset_management.model.ItemReturn;
import com.api.asset_management.payload.ApiResponse;
import com.api.asset_management.payload.ItemReturnRequest;
import com.api.asset_management.services.ItemReturnService;

@RestController
public class ItemReturnController {

	@Autowired
	private ItemReturnService itemReturnService;

	@GetMapping("/getAllItemReturn")
	public ResponseEntity<ApiResponse> getAllItemReturn() {
		ApiResponse itms = itemReturnService.getAllItemReturn();
		return new ResponseEntity<>(itms, HttpStatus.OK);
	}

	@GetMapping("/getItemReturnById/{itemReturnId}")
	public ResponseEntity<ApiResponse> getItemReturnById(@PathVariable UUID itemReturnId) {
		ApiResponse itm = itemReturnService.getItemReturnById(itemReturnId);
		return new ResponseEntity<>(itm, HttpStatus.OK);
	}

	@PostMapping("/addItemReturn")
	public ResponseEntity<ItemReturn> addItemReturn(@Valid @RequestBody ItemReturnRequest itemReturn) {
		return new ResponseEntity<>(itemReturnService.addItemReturn(itemReturn), HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteItemReturn/{itemReturnId}")
	public ItemReturn addItemReturn(@PathVariable UUID itemReturnId) {
		return itemReturnService.deleteItemReturn(itemReturnId);
	}
}
