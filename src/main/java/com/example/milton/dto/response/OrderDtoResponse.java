package com.example.milton.dto.response;

import com.example.milton.domain.Address;
import com.example.milton.domain.Customer;
import com.example.milton.domain.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDtoResponse {
    private String id;
    private String orderTrackingNumber;
    private int totalQuantity;
    private BigDecimal totalPrice;
    private String status;
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private List<OrderItem> orderItems = new ArrayList<>();
}
