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

import com.api.asset_management.model.Branch;
import com.api.asset_management.payload.BranchRequest;
import com.api.asset_management.services.BranchService;

@RestController
public class BranchController {

	@Autowired
	private BranchService branchService;

	@GetMapping("/getAllBranch")
	public List<Branch> getAllBranch() {
		return branchService.getAllBranch();
	}

	@GetMapping("/getBranchById/{branchId}")
	public Branch getBranchById(@PathVariable UUID branchId) {
		return branchService.getBranchById(branchId);
	}

	@PostMapping("/addBranch")
	public void addBranch(@Valid @RequestBody BranchRequest branch) {
		branchService.addBranch(branch);
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
