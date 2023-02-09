package com.api.asset_management.payload;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetUserRequest {
	@NotBlank(message = "Password should not be blank or null")
	@Min(value = 5)
	private String password;
}
