package com.api.asset_management.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Item {
	@Id
	private UUID itemId = UUID.randomUUID();
	@Column(nullable = false)
	private String itemName;
	@Column(nullable = false, unique = true)
	private String serialNumber;
	private String status;
	@Column(nullable = false)
	private float price;
	@Column(nullable = false)
	private long datePurchased;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id", referencedColumnName = "categoryId")
	private Category category;
}
