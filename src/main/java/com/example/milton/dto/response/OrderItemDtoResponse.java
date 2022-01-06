package com.example.milton.dto.response;

import com.example.milton.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDtoResponse {
    private String id;
    private String imageUrl;
    private BigDecimal unitPrice;
    private int quantity;
    private Long productId;
    private Order order;

}
