package com.api.asset_management.payload;

import java.time.LocalDate;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemAssignRequest {
	@NotBlank(message = "dateAssigned should not be blank or null")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateAssigned;
	@NotBlank(message = "remarks should not be blank or null")
	private String remarks;
	@NotBlank(message = "employeeId should not be blank or null")
	private String employeeId;
	@NotBlank(message = "itemId should not be blank or null")
	private UUID itemId;
}
