package com.example.milton.dto.request;

import com.example.milton.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDtoRequest {
    private String id;
    private String country;
    private String city;
    private String state;
    private String street;
    private String zipCode;
    private Order order;
}
