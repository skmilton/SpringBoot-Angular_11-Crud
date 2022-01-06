package com.example.milton.controller;

import com.example.milton.dto.request.ProductCategoryDtoRequest;
import com.example.milton.dto.response.ProductCategoryDtoResponse;
import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.service.ProductCategoryService;
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
@RequestMapping("productCategory")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryInfoService ;

    @PostMapping("/create")
    public ResponseEntity<IdentificationResponse> createProductCategory(
            @RequestBody @Valid ProductCategoryDtoRequest productCategoryDtoRequest, BindingResult bindingResult,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        return new ResponseEntity(productCategoryInfoService.createProductCategory(productCategoryDtoRequest), HttpStatus.CREATED);
    }
    @GetMapping("/show/all/list")
    public ResponseEntity<ProductCategoryDtoResponse> getAllProductCategory(){

        return new ResponseEntity(productCategoryInfoService.getAllProductCategoryList(), HttpStatus.OK);
    }

    @GetMapping("/show/list/by/{id}")
    public ResponseEntity<ProductCategoryDtoResponse> getAllProductCategoryById(@PathVariable String id){
        return new ResponseEntity<ProductCategoryDtoResponse>(productCategoryInfoService.getProductCategoryById(id), HttpStatus.OK);


    }
    @PostMapping("/update/productCategory/by/{id}")
    public void updateProductCategoryList(@RequestBody ProductCategoryDtoRequest productCategoryDtoRequest, @PathVariable String id) {
        productCategoryInfoService.updateProductCategory(productCategoryDtoRequest, id);
    }
    @DeleteMapping("/delete/productCategoryList/by/{id}")
    public void deleteProductCategory(@PathVariable String id ) {
        productCategoryInfoService.deleteProductCategory(id);
    }

}
