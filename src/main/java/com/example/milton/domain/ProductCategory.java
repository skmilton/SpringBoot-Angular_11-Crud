package com.example.milton.domain;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table (name = "productCategory")
public class ProductCategory extends BaseEntity{

    private String categoryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Product> products;
}
