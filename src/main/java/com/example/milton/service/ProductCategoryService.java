package com.example.milton.service;

import com.example.milton.domain. ProductCategory;

import com.example.milton.dto.request. ProductCategoryDtoRequest;
import com.example.milton.dto.response.IdentificationResponse;

import com.example.milton.dto.response. ProductCategoryDtoResponse;
import com.example.milton.repository. ProductCategoryRepository;

import com.example.milton.serviceIMPL.ProductCategoryServiceIMPL;
import com.example.milton.util.UuidUtil;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class  ProductCategoryService implements ProductCategoryServiceIMPL {
    private  ProductCategoryRepository  productCategoryRepository;
    private UuidUtil uuidUtil;

 @Override
    public IdentificationResponse createProductCategory( ProductCategoryDtoRequest  productCategoryDtoRequest) {

        String id = uuidUtil.getUuidUtil();

         ProductCategory  productCategoryInformation = new  ProductCategory();
         productCategoryInformation.setId(id);


        /*Bean Util Sob Entity thaka Sob nea asa*/
          BeanUtils.copyProperties( productCategoryDtoRequest, productCategoryInformation );

         productCategoryRepository.saveAndFlush( productCategoryInformation);

        return new IdentificationResponse(id);
    }

    @Override
    public List< ProductCategoryDtoResponse> getAllProductCategoryList() {

        List< ProductCategory>  productCategoryList =  productCategoryRepository.findAll();
        List< ProductCategoryDtoResponse>  productCategoryDtoResponseList = new ArrayList<>();
        for ( ProductCategory  productCategory :  productCategoryList) {
             ProductCategoryDtoResponse  productCategoryDtoResponse = new  ProductCategoryDtoResponse();

             productCategoryDtoResponse.setId( productCategory.getId());

            /*Bean Util Sob Entity thaka Sob nea asa*/
            BeanUtils.copyProperties( productCategoryList, productCategoryList );

             productCategoryDtoResponseList.add( productCategoryDtoResponse);
        }

        return  productCategoryDtoResponseList;
    }

    @Override
    public  ProductCategoryDtoResponse getProductCategoryById(String id) {

        Optional< ProductCategory>  productCategoryOptional =  productCategoryRepository.findAllById(id);

        if (! productCategoryOptional.isPresent()) {
            throw new RuntimeException(" ProductCategory not Found");
        }
         ProductCategory  productCategoryinfo =  productCategoryOptional.get();
         ProductCategoryDtoResponse  productCategoryDtoResponse = new  ProductCategoryDtoResponse();

         productCategoryDtoResponse.setId( productCategoryinfo.getId());

        /*Bean Util Sob Entity thaka Sob nea asa*/
        BeanUtils.copyProperties( productCategoryinfo, productCategoryinfo );

        return  productCategoryDtoResponse;
    }

    @Override
    public void updateProductCategory( ProductCategoryDtoRequest  productCategoryDtoRequest, String id) {

        Optional< ProductCategory>  productCategoryOptional =  productCategoryRepository.findAllById(id);
        if (! productCategoryOptional.isPresent()) {
            throw new RuntimeException(" ProductCategory not Found");
        }
         ProductCategory  productCategoryinfo =  productCategoryOptional.get();
        productCategoryinfo.setId(productCategoryDtoRequest.getId());

        /*Bean Util Sob Entity thaka Sob nea asa*/
        BeanUtils.copyProperties(productCategoryDtoRequest, productCategoryOptional);

         productCategoryRepository.save( productCategoryinfo);
    }

    @Override
    public void deleteProductCategory(String id) {
        Optional< ProductCategory>  productCategoryOptional =  productCategoryRepository.findAllById(id);
        if (! productCategoryOptional.isPresent()) {
            throw new RuntimeException(" ProductCategory Not Found");
        }
         ProductCategory  productCategoryinfo =  productCategoryOptional.get();
         productCategoryRepository.delete( productCategoryinfo);
    }
}
