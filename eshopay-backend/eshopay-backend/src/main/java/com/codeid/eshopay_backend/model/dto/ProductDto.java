package com.codeid.eshopay_backend.model.dto;


import com.codeid.eshopay_backend.model.entity.Category;
import com.codeid.eshopay_backend.model.entity.Suppliers;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private Long productId;

    @Size(max=40,message="panjang nama product max 40 karakter") 
    private String productName;

    @Size(max=20,message="panjang nama product max 40 karakter") 
    private String quantityPerUnit;

    private Double unitPrice;

    private Long unitsInStock;

    private Long unitsOnOrder;

    private Long reorderLevel;

    private Long disContinued;

    private String photo;

    private Long supplierId; 

    private  Long categoryId;
    
    
}
