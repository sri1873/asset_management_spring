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
public class Department {
	@Id
	@Builder.Default
	private UUID departmentId = UUID.randomUUID();
	@Column(nullable = false, unique = true)
	private String departmentName;
	@Column(nullable = false)
	private String description;

	@OneToMany(mappedBy = "department")
	private List<Employee> employee;
}
