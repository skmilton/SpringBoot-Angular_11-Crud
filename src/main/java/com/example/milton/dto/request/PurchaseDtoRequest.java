package com.example.milton.dto.request;

import com.example.milton.domain.Address;
import com.example.milton.domain.Customer;
import com.example.milton.domain.Order;
import com.example.milton.domain.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PurchaseDtoRequest {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private List<OrderItem> orderItems;
}
