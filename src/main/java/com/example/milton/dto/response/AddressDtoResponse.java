package com.example.milton.dto.response;

import com.example.milton.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDtoResponse {
    private String id;
    private String country;
    private String city;
    private String state;
    private String street;
    private String zipCode;
    private Order order;
}
