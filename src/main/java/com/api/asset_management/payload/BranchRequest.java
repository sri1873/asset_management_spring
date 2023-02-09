package com.api.asset_management.payload;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BranchRequest {
	@NotNull(message = "location should not be null")
	private String location;
	@NotNull(message = "contact should not be null and should be 10 digits only")
	@Min(value = 10)
	@Max(value = 10)
	private long contact;
}
