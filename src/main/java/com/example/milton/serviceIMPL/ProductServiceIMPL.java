package com.example.milton.serviceIMPL;

import com.example.milton.domain.Product;
import com.example.milton.dto.request.ProductDtoRequest;
import com.example.milton.dto.request.ProductDtoRequest;
import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.dto.response.ProductDtoResponse;

import java.util.List;

public interface ProductServiceIMPL {
    public IdentificationResponse createProduct(ProductDtoRequest productDtoRequest);
    public List<ProductDtoResponse> getAllProductList();
    public ProductDtoResponse getProductById(String id);
    public void updateProduct(ProductDtoRequest productDtoRequest, String id);
    public void deleteProduct(String id);
}
