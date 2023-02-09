package com.api.asset_management.payload;

import java.util.UUID;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequest {
	@NotBlank(message = "employeeId should not be blank or null")
	private String employeeId;
	@NotBlank(message = "First name should not be blank or null")
	private String firstName;
	@NotBlank(message = "last name should not be blank or null")
	private String lastName;
	@NotBlank(message = "Password should not be blank or null")
	@Min(value = 5)
	private String password;
	@NotNull(message = "phoneNumber should not be null and should be 10 digits only")
	@Min(value = 10)
	@Max(value = 10)
	private long phoneNumber;
	@NotBlank(message = "email should not be blank or null")
	private String email;
	@NotBlank(message = "departmentId should not be blank or null")
	private UUID departmentId;
	@NotBlank(message = "branchId should not be blank or null")
	private UUID branchId;
}
