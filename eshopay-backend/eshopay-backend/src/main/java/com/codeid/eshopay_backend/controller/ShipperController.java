package com.codeid.eshopay_backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeid.eshopay_backend.model.dto.ShippersDto;
import com.codeid.eshopay_backend.service.BaseCrudService;
import com.codeid.eshopay_backend.service.ShippersService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/shipper/")
public class ShipperController extends BaseCrudController<ShippersDto, Long>{
    
    private final ShippersService shipperService;

    @Override
    protected BaseCrudService<ShippersDto, Long> getService() {
        return shipperService;    
    }

    @Override
    public ResponseEntity<ShippersDto> create(@Valid ShippersDto entity) {
        return super.create(entity);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        return super.delete(id);
    }

    @Override
    public ResponseEntity<List<ShippersDto>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity<ShippersDto> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<ShippersDto> update(Long id, @Valid ShippersDto entity) {
        return super.update(id, entity);
    }
    
}