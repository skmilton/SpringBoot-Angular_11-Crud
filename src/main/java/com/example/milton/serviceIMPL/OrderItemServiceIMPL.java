package com.example.milton.serviceIMPL;

import com.example.milton.dto.request.OrderItemDtoRequest;
import com.example.milton.dto.response.OrderItemDtoResponse;
import com.example.milton.dto.response.IdentificationResponse;

import java.util.List;

public interface OrderItemServiceIMPL {
    public IdentificationResponse createOrderItem(OrderItemDtoRequest orderItemDtoRequest);
    public List<OrderItemDtoResponse> getAllOrderItemList();
    public OrderItemDtoResponse getOrderItemById(String id);
    public void updateOrderItem(OrderItemDtoRequest orderItemDtoRequest, String id);
    public void deleteOrderItem(String id);
}
