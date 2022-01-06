package com.example.milton.controller;

import com.example.milton.dto.request.AddressDtoRequest;
import com.example.milton.dto.response.AddressDtoResponse;
import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.service.AddressService;
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
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressInfoService ;

    @PostMapping("/create")
    public ResponseEntity<IdentificationResponse> createAddress(
            @RequestBody @Valid AddressDtoRequest addressDtoRequest, BindingResult bindingResult,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        return new ResponseEntity(addressInfoService.createAddress(addressDtoRequest), HttpStatus.CREATED);
    }
    @GetMapping("/show/all/list")
    public ResponseEntity<AddressDtoResponse> getAllAddress(){

        return new ResponseEntity(addressInfoService.getAllAddressList(), HttpStatus.OK);
    }

    @GetMapping("/show/list/by/{id}")
    public ResponseEntity<AddressDtoResponse> getAllAddressById(@PathVariable String id){
        return new ResponseEntity<AddressDtoResponse>(addressInfoService.getAddressById(id), HttpStatus.OK);


    }
    @PostMapping("/update/address/by/{id}")
    public void updateAddressList(@RequestBody AddressDtoRequest addressDtoRequest, @PathVariable String id) {
        addressInfoService.updateAddress(addressDtoRequest, id);
    }
    @DeleteMapping("/delete/addressList/by/{id}")
    public void deleteAddress(@PathVariable String id ) {
        addressInfoService.deleteAddress(id);
    }


}
