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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemReturnRequest {
	@NotBlank(message = "dateReturned should not be blank or null")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateReturned;
	@NotBlank(message = "remarks should not be blank or null")
	private String remarks;
	@NotBlank(message = "condition should not be blank or null")
	private String condition;
	@NotBlank(message = "charges should not be blank or null")
	private int charges;
	@NotBlank(message = "itemId should not be blank or null")
	private UUID itemId;

	private UUID itemAssignId;
}
