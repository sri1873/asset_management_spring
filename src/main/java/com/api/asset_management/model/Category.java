package com.api.asset_management.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Category {
	@Id
	private UUID categoryId = UUID.randomUUID();
	@Column(nullable = false, unique = true)
	private String categoryName;
	@Column(nullable = false)
	private long description;
}
