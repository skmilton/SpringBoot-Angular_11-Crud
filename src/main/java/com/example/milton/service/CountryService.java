package com.example.milton.service;

import com.example.milton.domain.Country;
import com.example.milton.dto.request.CountryDtoRequest;
import com.example.milton.dto.response.CountryDtoResponse;
import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.repository.CountryRepository;
import com.example.milton.serviceIMPL.CountryServiceIMPL;
import com.example.milton.util.UuidUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CountryService implements CountryServiceIMPL {

    private CountryRepository countryRepository;
    private UuidUtil uuidUtil;

    @Override
    public IdentificationResponse createCountry(CountryDtoRequest countryDtoRequest) {

        String id = uuidUtil.getUuidUtil();

        Country countryInformation = new Country();
        countryInformation.setId(id);


        /*Bean Util Sob Entity thaka Sob nea asa*/
        BeanUtils.copyProperties(countryDtoRequest,countryInformation );

        countryRepository.saveAndFlush(countryInformation);

        return new IdentificationResponse(id);
    }

    @Override
    public List<CountryDtoResponse> getAllCountryList() {

        List<Country> countryList = countryRepository.findAll();
        List<CountryDtoResponse> countryDtoResponseList = new ArrayList<>();
        for (Country country : countryList) {
            CountryDtoResponse countryDtoResponse = new CountryDtoResponse();

            countryDtoResponse.setId(country.getId());
            countryDtoResponse.setName(country.getName());
            countryDtoResponse.setCode(country.getCode());
           countryDtoResponse.setStates(country.getStates());

            countryDtoResponseList.add(countryDtoResponse);
        }

        return countryDtoResponseList;
    }

    @Override
    public CountryDtoResponse getCountryById(String id) {

        Optional<Country> countryOptional = countryRepository.findAllById(id);

        if (!countryOptional.isPresent()) {
            throw new RuntimeException("Country not Found");
        }
        Country countryinfo = countryOptional.get();
        CountryDtoResponse countryDtoResponse = new CountryDtoResponse();

        countryDtoResponse.setId(countryinfo.getId());
        countryDtoResponse.setName(countryinfo.getName());
        countryDtoResponse.setCode(countryinfo.getCode());
        countryDtoResponse.setStates(countryinfo.getStates());

        return countryDtoResponse;
    }

    @Override
    public void updateCountry(CountryDtoRequest countryDtoRequest, String id) {

        Optional<Country> countryOptional = countryRepository.findAllById(id);
        if (!countryOptional.isPresent()) {
            throw new RuntimeException("Country not Found");
        }
        Country countryinfo = countryOptional.get();
        BeanUtils.copyProperties(countryDtoRequest, countryOptional);
        countryRepository.save(countryinfo);
    }

    @Override
    public void deleteCountry(String id) {
        Optional<Country> countryOptional = countryRepository.findAllById(id);
        if (!countryOptional.isPresent()) {
            throw new RuntimeException("Country Not Found");
        }
        Country countryinfo = countryOptional.get();
        countryRepository.delete(countryinfo);
    }
}
