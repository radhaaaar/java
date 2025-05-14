package com.codeid.eshopay_backend.model.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public abstract class AbstractEntity {
    @Column(name ="created_date",nullable = false)
    private Instant createdDate = Instant.now();
    @Column(name="modified_date")
    @Version
    private Instant modified_date = Instant.now();

    
}
