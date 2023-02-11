package com.api.asset_management.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.asset_management.exception.ResourceNotFoundException;
import com.api.asset_management.model.Branch;
import com.api.asset_management.payload.ApiResponse;
import com.api.asset_management.payload.BranchRequest;
import com.api.asset_management.repository.BranchRepository;
import com.api.asset_management.utils.AppConstants;

@Service
public class BranchService {
	@Autowired
	private BranchRepository branchRepository;

	public ApiResponse getAllBranch() {
		List<Branch> branches = branchRepository.findAll();
		return ApiResponse.builder().data(branches).status(HttpStatus.OK).message(AppConstants.RETRIEVAL_SUCCESS)
				.success(Boolean.TRUE).errors(new ArrayList<>()).build();
	}

	public ApiResponse getBranchById(UUID branchId) {
		Branch branch = branchRepository.findByUuid(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("Branch not found with id: " + branchId));
		return ApiResponse.builder().data(branch).status(HttpStatus.OK).message(AppConstants.RETRIEVAL_SUCCESS)
				.success(Boolean.TRUE).errors(new ArrayList<>()).build();
	}

	@Transactional
	public void deleteBranch(UUID branchId) {
		branchRepository.deleteByUuid(branchId);
	}

	public Branch addBranch(BranchRequest branch) {
		Branch branch1 = Branch.builder().contact(branch.getContact()).location(branch.getLocation()).build();
		return branchRepository.save(branch1);
	}
}
