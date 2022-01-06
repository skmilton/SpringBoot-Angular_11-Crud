package com.example.milton.repository;

import com.example.milton.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory , String> {
    Optional<ProductCategory> findAllById(String id);
}
