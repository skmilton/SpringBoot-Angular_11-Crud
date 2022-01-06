package com.example.milton.dto.response;

import com.example.milton.domain.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDtoResponse {
    private String id;
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
