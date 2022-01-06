package com.example.milton.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
@Data
@Entity
@Table(name = "orderItem")
public class OrderItem extends BaseEntity{

    private String imageUrl;
    private BigDecimal unitPrice;
    private int quantity;
    private Long productId;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
