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

import com.api.asset_management.model.Branch;
import com.api.asset_management.model.services.BranchService;

@RestController
public class BranchController {

	@Autowired
	private BranchService branchService;

	@GetMapping("/getAllBranch")
	public List<Branch> getAllBranch() {
		return branchService.getAllBranch();
	}

	@GetMapping("/getBranchById/{branch_id}")
	public Branch getBranchById(@PathVariable UUID branchId) {
		return branchService.getBranchById(branchId);
	}

	@PostMapping("/addBranch")
	public void addBranch(@RequestBody Branch branch) {
		branchService.addBranch(branch);
	}

	@DeleteMapping("/deleteBranch/{branch_id}")
	public Branch addBranch(@PathVariable UUID branchId) {
		return branchService.deleteBranch(branchId);
	}

	//	@PutMapping("/updateEmployeeById/{employee_id}")
	//	public Branch updateEmployeeById(@PathVariable String employeeId) {
	//		return employeeService.updateEmployeeById(employeeId);
	//	}
}
