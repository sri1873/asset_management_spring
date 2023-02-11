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

import com.api.asset_management.model.Branch;
import com.api.asset_management.payload.ApiResponse;
import com.api.asset_management.payload.BranchRequest;
import com.api.asset_management.services.BranchService;

@RestController
public class BranchController {

	@Autowired
	private BranchService branchService;

	@GetMapping("/getAllBranch")
	public ResponseEntity<ApiResponse> getAllBranch() {
		ApiResponse branches = branchService.getAllBranch();
		return new ResponseEntity<>(branches, HttpStatus.OK);
	}

	@GetMapping("/getBranchById/{branchId}")
	public ResponseEntity<ApiResponse> getBranchById(@PathVariable UUID branchId) {
		ApiResponse branch = branchService.getBranchById(branchId);
		return new ResponseEntity<>(branch, HttpStatus.OK);
	}

	@PostMapping("/addBranch")
	public ResponseEntity<Branch> addBranch(@Valid @RequestBody BranchRequest branch) {
		Branch br1 = branchService.addBranch(branch);
		return new ResponseEntity<>(br1, HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteBranch/{branchId}")
	public void addBranch(@PathVariable UUID branchId) {
		branchService.deleteBranch(branchId);
	}

	//	@PutMapping("/updateEmployeeById/{branchId}")
	//	public Branch updateEmployeeById(@PathVariable String branchId) {
	//		return employeeService.updateEmployeeById(branchId);
	//	}
}
