package com.example.milton.dto.response;

import com.example.milton.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductCategoryDtoResponse {
    private String id;
    private String categoryName;
    private List<Product> products;
}
