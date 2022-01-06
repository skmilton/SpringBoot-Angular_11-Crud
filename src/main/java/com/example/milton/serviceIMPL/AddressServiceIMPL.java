package com.example.milton.serviceIMPL;

import com.example.milton.dto.request.AddressDtoRequest;
import com.example.milton.dto.response.AddressDtoResponse;
import com.example.milton.dto.response.IdentificationResponse;

import java.util.List;

public interface AddressServiceIMPL {
    public IdentificationResponse createAddress(AddressDtoRequest addressDtoRequest);
    public List<AddressDtoResponse> getAllAddressList();
    public AddressDtoResponse getAddressById(String id);
    public void updateAddress(AddressDtoRequest addressDtoRequest, String id);
    public void deleteAddress(String id);
    
}
