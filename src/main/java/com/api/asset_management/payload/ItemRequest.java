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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemRequest {
	@NotBlank(message = "itemName should not be blank or null")
	private String itemName;
	@NotBlank(message = "serialNumber should not be blank or null")
	private String serialNumber;
	@NotBlank(message = "status should not be blank or null")
	private String status;
	@NotBlank(message = "price should not be blank or null")
	private float price;
	@NotBlank(message = "datePurchased should not be blank or null")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate datePurchased;
	@NotBlank(message = "categoryId should not be blank or null")
	private UUID categoryId;
}
