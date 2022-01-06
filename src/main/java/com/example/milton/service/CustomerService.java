package com.example.milton.service;

import com.example.milton.domain.Customer;

import com.example.milton.domain.Customer;
import com.example.milton.domain.Product;
import com.example.milton.dto.request.CustomerDtoRequest;
import com.example.milton.dto.response.CustomerDtoResponse;

import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.repository.CustomerRepository;
import com.example.milton.serviceIMPL.CustomerServiceIMPL;
import com.example.milton.util.UuidUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class CustomerService implements CustomerServiceIMPL {

    private CustomerRepository customerRepository;
    private UuidUtil uuidUtil;

    @Override
    public IdentificationResponse createCustomer(CustomerDtoRequest customerDtoRequest) {
        String id = uuidUtil.getUuidUtil();

        Customer customerInformation = new Customer();

        customerInformation.setId(id);
        BeanUtils.copyProperties(customerDtoRequest, customerInformation);
        customerRepository.saveAndFlush(customerInformation);

        return new IdentificationResponse(id);
    }

    @Override
    public List<CustomerDtoResponse> getAllCustomerList() {

        List<Customer> customerInformationList = customerRepository.findAll();
        List<CustomerDtoResponse> customerDtoResponseList = new ArrayList<>();
        for (Customer customerInformation : customerInformationList) {

            CustomerDtoResponse customerDtoResponse = new CustomerDtoResponse();

            customerDtoResponse.setCustomerName(customerInformation.getCustomerName());
            customerDtoResponse.setAddress(customerInformation.getAddress());
            customerDtoResponse.setMobile(customerInformation.getMobile());
            customerDtoResponse.setEmail(customerInformation.getEmail());
            customerDtoResponse.setPassword(customerInformation.getPassword());
            customerDtoResponseList.add(customerDtoResponse);
        }
        return customerDtoResponseList;
    }

    @Override
    public CustomerDtoResponse getCustomerById(String id) {
        Optional<Customer> customerOptional = customerRepository.findAllById(id);

        if (!customerOptional.isPresent()) {
            throw new RuntimeException("Customer Not Found");
        }

        Customer customerInformation = customerOptional.get();

        CustomerDtoResponse customerDtoResponse = new CustomerDtoResponse();

      customerDtoResponse.setId(customerInformation.getId());
        customerDtoResponse.setCustomerName(customerInformation.getCustomerName());
        customerDtoResponse.setAddress(customerInformation.getAddress());
        customerDtoResponse.setMobile(customerInformation.getMobile());
        customerDtoResponse.setEmail(customerInformation.getEmail());
        customerDtoResponse.setPassword(customerInformation.getPassword());

        return customerDtoResponse;
    }

    @Override
    public void updateCustomer(CustomerDtoRequest customerDtoRequest, String id) {

        Optional<Customer> customerInformationOptional = customerRepository.findAllById(id);

        if (!customerInformationOptional.isPresent()) {
            throw new RuntimeException("Customer Nnnot Found");
        }
        Customer customerInformation = customerInformationOptional.get();
        customerInformation.setId(customerDtoRequest.getId());

        customerInformation.setCustomerName(customerDtoRequest.getCustomerName());
        customerInformation.setMobile(customerDtoRequest.getMobile());

        customerInformation.setAddress(customerDtoRequest.getAddress());
        customerInformation.setEmail(customerDtoRequest.getEmail());
        customerInformation.setPassword(customerDtoRequest.getPassword());
        customerRepository.save(customerInformation);
    }

    @Override
    public void deleteCustomer(String id) {
        Optional<Customer> customerInformationOptional = customerRepository.findAllById(id);
        if (!customerInformationOptional.isPresent()) {
            throw new RuntimeException("Customer not Found");
        }
        Customer customerInformation = customerInformationOptional.get();
        customerRepository.delete(customerInformation);
    }
}
