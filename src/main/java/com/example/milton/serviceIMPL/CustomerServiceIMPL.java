package com.example.milton.serviceIMPL;

import com.example.milton.dto.request.CustomerDtoRequest;
import com.example.milton.dto.response.CustomerDtoResponse;
import com.example.milton.dto.response.IdentificationResponse;

import java.util.List;

public interface CustomerServiceIMPL {

    public IdentificationResponse createCustomer(CustomerDtoRequest customerDtoRequest);
    public List<CustomerDtoResponse> getAllCustomerList();
    public CustomerDtoResponse getCustomerById(String id);
    public void updateCustomer(CustomerDtoRequest customerDtoRequest, String id);
    public void deleteCustomer(String id);

    
}
