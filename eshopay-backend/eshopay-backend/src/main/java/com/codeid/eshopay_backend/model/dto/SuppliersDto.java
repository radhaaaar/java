package com.codeid.eshopay_backend.model.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SuppliersDto {
    private Long suppliersId;

    @Size(max = 50, message = "Length value must not exceeded than 50")
    private String companyName;
}
