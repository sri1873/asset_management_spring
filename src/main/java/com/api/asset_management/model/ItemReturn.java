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
public class ItemReturn {

	@Id
	private UUID retrivalId = UUID.randomUUID();
	@Column(nullable = false)
	private long dateReturned;
	@Column(nullable = false)
	private String remarks;
	private String status;
	@Column(nullable = false)
	private String condition;
	@Column(nullable = false)
	private int charges;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "item_id", referencedColumnName = "itemId")
	private Item item;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "assignment_id", referencedColumnName = "assignmentId")
	private ItemAssign itemAssign;
}
