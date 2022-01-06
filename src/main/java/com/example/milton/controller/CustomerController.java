package com.example.milton.controller;

import com.example.milton.dto.request.CustomerDtoRequest;
import com.example.milton.dto.response.CustomerDtoResponse;
import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.service.CustomerService;
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
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerInfoService ;

    @PostMapping("/create")
    public ResponseEntity<IdentificationResponse> createCustomer(
            @RequestBody @Valid CustomerDtoRequest customerDtoRequest, BindingResult bindingResult,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        return new ResponseEntity(customerInfoService.createCustomer(customerDtoRequest), HttpStatus.CREATED);
    }
    @GetMapping("/show/all/list")
    public ResponseEntity<CustomerDtoResponse> getAllCustomer(){

        return new ResponseEntity(customerInfoService.getAllCustomerList(), HttpStatus.OK);
    }

    @GetMapping("/show/list/by/{id}")
    public ResponseEntity<CustomerDtoResponse> getAllCustomerById(@PathVariable String id){
        return new ResponseEntity<CustomerDtoResponse>(customerInfoService.getCustomerById(id), HttpStatus.OK);


    }
    @PostMapping("/update/customer/by/{id}")
    public void updateCustomerList(@RequestBody CustomerDtoRequest customerDtoRequest, @PathVariable String id) {
        customerInfoService.updateCustomer(customerDtoRequest, id);
    }
    @DeleteMapping("/delete/customerList/by/{id}")
    public void deleteCustomer(@PathVariable String id ) {
        customerInfoService.deleteCustomer(id);
    }

}
