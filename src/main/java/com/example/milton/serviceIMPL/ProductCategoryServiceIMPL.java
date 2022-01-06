package com.example.milton.serviceIMPL;

import com.example.milton.dto.request. ProductCategoryDtoRequest;
import com.example.milton.dto.response. ProductCategoryDtoResponse;
import com.example.milton.dto.response.IdentificationResponse;

import java.util.List;

public interface ProductCategoryServiceIMPL {
    public IdentificationResponse createProductCategory( ProductCategoryDtoRequest  productCategoryDtoRequest);
    public List< ProductCategoryDtoResponse> getAllProductCategoryList();
    public  ProductCategoryDtoResponse getProductCategoryById(String id);
    public void updateProductCategory( ProductCategoryDtoRequest  productCategoryDtoRequest, String id);
    public void deleteProductCategory(String id);
}
