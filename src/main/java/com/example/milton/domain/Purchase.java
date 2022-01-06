package com.example.milton.domain;

import lombok.*;

import javax.persistence.*;



@Data
@Entity
@Table(name = "purchase")

public class Purchase extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "shipping_address_id")
    private Address shippingAddress;
    @ManyToOne
    @JoinColumn(name = "billing_address_id")
    private Address billingAddress;
    @ManyToOne
    @JoinColumn(name = "order_order_tracking_number")
    private Order order;


   //private List<OrderItem> orderItems;
}
