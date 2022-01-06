package com.example.milton.serviceIMPL;

import com.example.milton.domain.Purchase;
import com.example.milton.dto.request.CountryDtoRequest;
import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.dto.response.CountryDtoResponse;
import com.example.milton.dto.response.PurchaseDtoResponse;

import java.util.List;

public interface CountryServiceIMPL {
    public IdentificationResponse createCountry(CountryDtoRequest countryDtoRequest);
    public List<CountryDtoResponse> getAllCountryList();
    public CountryDtoResponse getCountryById(String id);
    public void updateCountry(CountryDtoRequest countryDtoRequest, String id);
    public void deleteCountry(String id);

    }

