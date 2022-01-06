package com.example.milton.dto.request;

import com.example.milton.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductCategoryDtoRequest {
    private String id;
    private String categoryName;
    private List<Product> products;
}
