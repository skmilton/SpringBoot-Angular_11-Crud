package com.example.milton.controller;

import com.example.milton.dto.request.CountryDtoRequest;
import com.example.milton.dto.response.CountryDtoResponse;
import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/country")
public class CountryController {
    
        @Autowired
        private CountryService countryInfoService ;

        @PostMapping("/create")
        public ResponseEntity<IdentificationResponse> createCountry(
                @RequestBody @Valid CountryDtoRequest countryDtoRequest, BindingResult bindingResult,
                HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

            return new ResponseEntity(countryInfoService.createCountry(countryDtoRequest), HttpStatus.CREATED);
        }
        @GetMapping("/show/all/list")
        public ResponseEntity<CountryDtoResponse> getAllCountry(){

            return new ResponseEntity(countryInfoService.getAllCountryList(), HttpStatus.OK);
        }

        @GetMapping("/show/list/by/{id}")
        public ResponseEntity<CountryDtoResponse> getAllCountryById(@PathVariable String id){
            return new ResponseEntity<CountryDtoResponse>(countryInfoService.getCountryById(id), HttpStatus.OK);


        }
        @PostMapping("/update/country/by/{id}")
        public void updateCountryList(@RequestBody CountryDtoRequest countryDtoRequest, @PathVariable String id) {
            countryInfoService.updateCountry(countryDtoRequest, id);
        }
        @DeleteMapping("/delete/countryList/by/{id}")
        public void deleteCountry(@PathVariable String id ) {
            countryInfoService.deleteCountry(id);
        }

    }

