package com.api.asset_management.model.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.asset_management.model.Branch;
import com.api.asset_management.model.repository.BranchRepository;

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

	public Branch deleteBranch(UUID branchId) {
		branchRepository.deleteByUuid(branchId);
		return null;
	}

	public void addBranch(Branch branch) {
		branchRepository.save(branch);
	}
}
