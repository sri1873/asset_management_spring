package com.api.asset_management.payload;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRequest {
	@NotBlank(message = "categoryName should not be blank or null")
	private String categoryName;
	@NotBlank(message = "description should not be blank or null")
	private String description;
}
