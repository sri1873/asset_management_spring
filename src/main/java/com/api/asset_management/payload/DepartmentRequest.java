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
public class DepartmentRequest {
	@NotBlank(message = "departmentName should not be blank or null")
	private String departmentName;
	@NotBlank(message = "descriptione should not be blank or null")
	private String description;

}
