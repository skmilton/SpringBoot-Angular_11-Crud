package com.example.milton.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "order")
public class Order extends BaseEntity{
    private String orderTrackingNumber;
    private int totalQuantity;
    private BigDecimal totalPrice;
    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "shipping_address_id", referencedColumnName = "id")
    private Address shippingAddress;

    @OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
    private Address billingAddress;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    public void add(OrderItem item){
        if(item != null){
            if(orderItems == null){
                orderItems = new ArrayList<>();
            }
            orderItems.add(item);
            item.setOrder(this);
        }
    }
}
