package com.example.milton.service;

import com.example.milton.domain.Address;
import com.example.milton.dto.request.AddressDtoRequest;
import com.example.milton.dto.request.AddressDtoRequest;
import com.example.milton.dto.response.AddressDtoResponse;
import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.dto.response.AddressDtoResponse;
import com.example.milton.repository.AddressRepository;
import com.example.milton.serviceIMPL.AddressServiceIMPL;
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
public class AddressService implements AddressServiceIMPL {
    private AddressRepository addressRepository;
    private UuidUtil uuidUtil;

    @Override
    public IdentificationResponse createAddress(AddressDtoRequest addressDtoRequest) {

        String id = uuidUtil.getUuidUtil();

        Address addressInformation = new Address();
        addressInformation.setId(id);

        /*Bean Util Sob Entity thaka Sob nea asa*/
          BeanUtils.copyProperties(addressDtoRequest,addressInformation );

        addressRepository.saveAndFlush(addressInformation);

        return new IdentificationResponse(id);
    }

    @Override
    public List<AddressDtoResponse> getAllAddressList() {

        List<Address> addressList = addressRepository.findAll();
        List<AddressDtoResponse> addressDtoResponseList = new ArrayList<>();
        for (Address address : addressList) {
            AddressDtoResponse addressDtoResponse = new AddressDtoResponse();

            addressDtoResponse.setId(address.getId());
            addressDtoResponse.setCity(address.getCity());
            addressDtoResponse.setCountry(address.getCountry());
            addressDtoResponse.setState(address.getState());
            addressDtoResponse.setStreet(address.getStreet());
            addressDtoResponse.setZipCode(address.getZipCode());
            addressDtoResponse.setOrder(address.getOrder());

            addressDtoResponseList.add(addressDtoResponse);
        }

        return addressDtoResponseList;
    }

    @Override
    public AddressDtoResponse getAddressById(String id) {

        Optional<Address> addressOptional = addressRepository.findAllById(id);

        if (!addressOptional.isPresent()) {
            throw new RuntimeException("Address not Found");
        }
        Address addressinfo = addressOptional.get();
        AddressDtoResponse addressDtoResponse = new AddressDtoResponse();

        addressDtoResponse.setId(addressinfo.getId());
        addressDtoResponse.setCity(addressinfo.getCity());
        addressDtoResponse.setCountry(addressinfo.getCountry());
        addressDtoResponse.setState(addressinfo.getState());
        addressDtoResponse.setStreet(addressinfo.getStreet());
        addressDtoResponse.setZipCode(addressinfo.getZipCode());
        addressDtoResponse.setOrder(addressinfo.getOrder());

        return addressDtoResponse;
    }

    @Override
    public void updateAddress(AddressDtoRequest addressDtoRequest, String id) {

        Optional<Address> addressOptional = addressRepository.findAllById(id);
        if (!addressOptional.isPresent()) {
            throw new RuntimeException("Address not Found");
        }
        Address addressinfo = addressOptional.get();
        BeanUtils.copyProperties(addressDtoRequest, addressOptional);
        addressRepository.save(addressinfo);
    }

    @Override
    public void deleteAddress(String id) {
        Optional<Address> addressOptional = addressRepository.findAllById(id);
        if (!addressOptional.isPresent()) {
            throw new RuntimeException("Address Not Found");
        }
        Address addressinfo = addressOptional.get();
        addressRepository.delete(addressinfo);
    }
}
