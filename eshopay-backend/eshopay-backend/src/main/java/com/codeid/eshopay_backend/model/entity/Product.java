package com.codeid.eshopay_backend.model.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="products",schema="oe")
public class Product extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id",nullable = false)
    private Long productId;

    @Nonnull
    @Column(name="product_name")
    private String productName;

    @Column(name="quantity_per_unit")
    private String quantityPerUnit;

    @Column(name="unit_price")
    private Double unitPrice;

    @Column(name="units_in_stock")
    private Long unitsInStock;

    @Column(name="units_on_order")
    private Long unitsOnOrder;

    @Column(name="reorder_level")
    private Long reorderLevel;

    @Column(name="discontinued")
    private Long disContinued;

    @Column(name="photo")
    private String photo;
    
    @ManyToOne
    @JoinColumn(name="supplier_id")
    private Suppliers supplier; 

    @ManyToOne
    @JoinColumn(name="category_id")
    private  Category category;

    
    
    
    
}
