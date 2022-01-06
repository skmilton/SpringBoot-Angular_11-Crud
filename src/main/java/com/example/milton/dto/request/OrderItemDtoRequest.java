package com.example.milton.dto.request;

import com.example.milton.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDtoRequest {
    private String id;
    private String imageUrl;
    private BigDecimal unitPrice;
    private int quantity;
    private Long productId;
    private Order order;
}
