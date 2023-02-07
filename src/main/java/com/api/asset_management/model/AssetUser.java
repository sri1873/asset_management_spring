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
public class AssetUser {
	@Id
	private UUID userId = UUID.randomUUID();
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false)
	private String password;
}
