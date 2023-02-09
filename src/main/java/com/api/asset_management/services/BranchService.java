package com.api.asset_management.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.asset_management.model.Branch;
import com.api.asset_management.payload.BranchRequest;
import com.api.asset_management.repository.BranchRepository;

@Service
public class BranchService {
	@Autowired
	private BranchRepository branchRepository;

	public List<Branch> getAllBranch() {
		return branchRepository.findAll();
	}

	public Branch getBranchById(UUID branchId) {
		return branchRepository.findByUuid(branchId);
	}

	public void deleteBranch(UUID branchId) {
		branchRepository.deleteByUuid(branchId);
	}

	public void addBranch(BranchRequest branch) {
		Branch branch1 = Branch.builder().contact(branch.getContact()).location(branch.getLocation()).build();
		branchRepository.save(branch1);
	}
}
