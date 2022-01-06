package com.example.milton.service;

import com.example.milton.domain.Product;
import com.example.milton.domain.ProductCategory;
import com.example.milton.dto.request.ProductDtoRequest;
import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.dto.response.ProductDtoResponse;
import com.example.milton.repository.ProductRepository;
import com.example.milton.serviceIMPL.ProductServiceIMPL;
import com.example.milton.util.UuidUtil;

import lombok.AllArgsConstructor;


import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@NoArgsConstructor
@Service
public class ProductService implements ProductServiceIMPL {

    private ProductRepository productRepository;
    private UuidUtil uuidUtil;

    @Override
    public IdentificationResponse createProduct(ProductDtoRequest productDtoRequest) {

        String id = uuidUtil.getUuidUtil();

        Product productInformation = new Product();
        productInformation.setId(id);
//        productInformation.setCategory(productDtoRequest.getCategory());
//        productInformation.setProductName(productDtoRequest.getProductName());
//        productInformation.setCode(productDtoRequest.getCode());
//        productInformation.setQty(productDtoRequest.getQty());
//        productInformation.setDescription(productDtoRequest.getDescription());
//        productInformation.setUnitPrice(productDtoRequest.getUnitPrice());
//        productInformation.setUnitsInStock(productDtoRequest.getUnitsInStock());
//        productInformation.setImageUrl(productDtoRequest.getImageUrl());

        /*Bean Util Sob Entity thaka Sob nea asa*/
          BeanUtils.copyProperties(productDtoRequest,productInformation );

        productRepository.saveAndFlush(productInformation);

        return new IdentificationResponse(id);
    }

    @Override
    public List<ProductDtoResponse> getAllProductList() {

        List<Product> productList = productRepository.findAll();
        List<ProductDtoResponse> productDtoResponseList = new ArrayList<>();
        for (Product product : productList) {
            ProductDtoResponse productDtoResponse = new ProductDtoResponse();

            productDtoResponse.setId(product.getId());
            productDtoResponse.setCategory(product.getCategory());
            productDtoResponse.setProductName(product.getProductName());
            productDtoResponse.setCode(product.getCode());
            productDtoResponse.setQty(product.getQty());
            productDtoResponse.setDescription(product.getDescription());
            productDtoResponse.setUnitPrice(product.getUnitPrice());
            productDtoResponse.setUnitsInStock(product.getUnitsInStock());
            productDtoResponse.setImageUrl(product.getImageUrl());

            productDtoResponseList.add(productDtoResponse);
        }

        return productDtoResponseList;
    }

    @Override
    public ProductDtoResponse getProductById(String id) {

        Optional<Product> productOptional = productRepository.findAllById(id);

        if (!productOptional.isPresent()) {
            throw new RuntimeException("Product not Found");
        }
        Product productinfo = productOptional.get();
        ProductDtoResponse productDtoResponse = new ProductDtoResponse();

        productDtoResponse.setId(productinfo.getId());
       productDtoResponse.setCategory(productinfo.getCategory());
        productDtoResponse.setProductName(productinfo.getProductName());
        productDtoResponse.setCode(productinfo.getCode());
        productDtoResponse.setQty(productinfo.getQty());
        productDtoResponse.setDescription(productinfo.getDescription());
        productDtoResponse.setUnitPrice(productinfo.getUnitPrice());
        productDtoResponse.setUnitsInStock(productinfo.getUnitsInStock());
        productDtoResponse.setImageUrl(productinfo.getImageUrl());

        return productDtoResponse;
    }

    @Override
    public void updateProduct(ProductDtoRequest productDtoRequest, String id) {

        Optional<Product> productOptional = productRepository.findAllById(id);
        if (!productOptional.isPresent()) {
            throw new RuntimeException("Product not Found");
        }
        Product productinfo = productOptional.get();
        BeanUtils.copyProperties(productDtoRequest, productOptional);
        productRepository.save(productinfo);
    }

    @Override
    public void deleteProduct(String id) {
        Optional<Product> productOptional = productRepository.findAllById(id);
        if (!productOptional.isPresent()) {
            throw new RuntimeException("Product Not Found");
        }
        Product productinfo = productOptional.get();
        productRepository.delete(productinfo);
    }
}
