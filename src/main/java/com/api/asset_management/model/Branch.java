package com.api.asset_management.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Builder
public class Branch {
	@Id
	@Builder.Default
	private UUID branchId = UUID.randomUUID();
	@Column(nullable = false)
	private String location;
	@Column(nullable = false)
	private long contact;

	@OneToMany(mappedBy = "branch")
	private List<Employee> employee;
}
