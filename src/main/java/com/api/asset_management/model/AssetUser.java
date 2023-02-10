package com.api.asset_management.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class AssetUser {
	@Id
	@Builder.Default
	private UUID userId = UUID.randomUUID();
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false)
	private String password;

	@JsonIgnore
	@OneToOne(mappedBy = "user")
	private Employee employee;
}
