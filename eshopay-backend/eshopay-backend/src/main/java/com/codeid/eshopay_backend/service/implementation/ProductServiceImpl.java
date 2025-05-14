package com.codeid.eshopay_backend.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.codeid.eshopay_backend.model.dto.ProductDto;
import com.codeid.eshopay_backend.model.entity.Category;
import com.codeid.eshopay_backend.model.entity.Product;
import com.codeid.eshopay_backend.model.entity.Suppliers;
import com.codeid.eshopay_backend.repository.ProductRepository;
import com.codeid.eshopay_backend.service.ProductService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final SuppliersServiceImpl suppliersServiceImpl;

    private final ProductRepository productRepository;

    public static ProductDto mapToDto(Product product) {
        return ProductDto.builder().productId(product.getProductId())
                .productName(product.getProductName())
                .quantityPerUnit(product.getQuantityPerUnit())
                .unitPrice(product.getUnitPrice())
                .unitsInStock(product.getUnitsInStock())
                .unitsOnOrder(product.getUnitsOnOrder())
                .reorderLevel(product.getReorderLevel())
                .disContinued(product.getDisContinued())
                .photo(product.getPhoto())
                .supplierId(product.getSupplier().getSupplierId())
                .categoryId(product.getCategory().getCategoryId())
                .build();
    }

    private Product mapToEntity(ProductDto productDto) {
        return Product.builder().productId(productDto.getProductId())
                .productName(productDto.getProductName())
                .quantityPerUnit(productDto.getQuantityPerUnit())
                .unitPrice(productDto.getUnitPrice())
                .unitsInStock(productDto.getUnitsInStock())
                .unitsOnOrder(productDto.getUnitsOnOrder())
                .reorderLevel(productDto.getReorderLevel())
                .disContinued(productDto.getDisContinued())
                .photo(productDto.getPhoto())
                .supplier(Suppliers.builder().supplierId(productDto.getSupplierId()).build())
                .category(Category.builder().categoryId(productDto.getCategoryId()).build())
                .build();
    }

    @Override
    public List<ProductDto> findAll() {
        log.debug("Request Fetching Data Categories");
        return this.productRepository.findAll()
                .stream()
                .map(ProductServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(Long id) {
        log.debug("Request to get Department : {}", id);

        return this.productRepository.findById(id).map(ProductServiceImpl::mapToDto)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));
    }

    @Override
    public ProductDto save(ProductDto entity) {
        log.debug("Request to create Employee : {}", entity);

        var product = mapToEntity(entity);

        return mapToDto(this.productRepository.save(product));

    }

    @Override
    public ProductDto update(Long id, ProductDto entity) {
        log.debug("Request to update Product : {}", id);

        var product = this.productRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));

        product.setProductName(entity.getProductName());
        product.setQuantityPerUnit(entity.getQuantityPerUnit());
        product.setUnitPrice(entity.getUnitPrice());
        product.setUnitsInStock(entity.getUnitsInStock());
        product.setUnitsOnOrder(entity.getUnitsOnOrder());
        product.setReorderLevel(entity.getReorderLevel());
        product.setDisContinued(entity.getDisContinued());
        product.setPhoto(entity.getPhoto());
        product.setSupplier(Suppliers.builder().supplierId(entity.getSupplierId()).build());
        product.setCategory(Category.builder().categoryId(entity.getCategoryId()).build());

        product = this.productRepository.save(product);

        return mapToDto(product);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Department : {}", id);

        var product = this.productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find product with id " + id));

        this.productRepository.delete(product);

    }

}