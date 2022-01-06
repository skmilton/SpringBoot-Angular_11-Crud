package com.example.milton.serviceIMPL;

import com.example.milton.dto.request.OrderDtoRequest;
import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.dto.response.OrderDtoResponse;
import java.util.List;

public interface OrderServiceIMPL {
    public IdentificationResponse createOrder(OrderDtoRequest orderDtoRequest);
    public List<OrderDtoResponse> getAllOrderList();
    public OrderDtoResponse getOrderById(String id);
    public void updateOrder(OrderDtoRequest orderDtoRequest, String id);
    public void deleteOrder(String id);
}
