package com.example.milton.controller;

import com.example.milton.dto.request.ProductDtoRequest;
import com.example.milton.dto.response.ProductDtoResponse;
import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<IdentificationResponse> createProduct(
            @RequestBody @Valid ProductDtoRequest productDtoRequest, BindingResult bindingResult,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        return new ResponseEntity(productService.createProduct(productDtoRequest), HttpStatus.CREATED);
    }

    @GetMapping("/show/all/list")
    public ResponseEntity<ProductDtoResponse> getAllProduct() {

        return new ResponseEntity(productService.getAllProductList(), HttpStatus.OK);
    }

    @GetMapping("/show/list/by/{id}")
    public ResponseEntity<ProductDtoResponse> getAllProductById(@PathVariable String id) {
        return new ResponseEntity<ProductDtoResponse>(productService.getProductById(id), HttpStatus.OK);


    }

    @PostMapping("/update/product/by/{id}")
    public void updateProductList(@RequestBody ProductDtoRequest productDtoRequest, @PathVariable String id) {
        productService.updateProduct(productDtoRequest, id);
    }

    @DeleteMapping("/delete/productList/by/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }

}
