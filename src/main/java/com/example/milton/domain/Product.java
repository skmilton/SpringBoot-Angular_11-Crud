package com.example.milton.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product")
public class Product extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private ProductCategory category;
    private String productName;
    private String code;
    private String qty;
    private String description;
    private BigDecimal unitPrice;
    private String imageUrl;
    private boolean active;
    private int unitsInStock;

}
