package com.example.milton.service;

import com.example.milton.domain.Order;
import com.example.milton.dto.request.OrderDtoRequest;
import com.example.milton.dto.request.OrderDtoRequest;
import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.dto.response.OrderDtoResponse;
import com.example.milton.dto.response.OrderDtoResponse;
import com.example.milton.repository.OrderRepository;
import com.example.milton.serviceIMPL.OrderServiceIMPL;
import com.example.milton.util.UuidUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class OrderService implements OrderServiceIMPL {
    private OrderRepository orderRepository;
    private UuidUtil uuidUtil;

    @Override
    public IdentificationResponse createOrder(OrderDtoRequest orderDtoRequest) {

        String id = uuidUtil.getUuidUtil();

        Order orderInformation = new Order();
        orderInformation.setId(id);

        /*Bean Util Sob Entity thaka Sob nea asa*/

          BeanUtils.copyProperties(orderDtoRequest,orderInformation );

        orderRepository.saveAndFlush(orderInformation);

        return new IdentificationResponse(id);
    }

    @Override
    public List<OrderDtoResponse> getAllOrderList() {

        List<Order> orderList = orderRepository.findAll();
        List<OrderDtoResponse> orderDtoResponseList = new ArrayList<>();
        for (Order order : orderList) {
            OrderDtoResponse orderDtoResponse = new OrderDtoResponse();

            orderDtoResponse.setId(order.getId());orderDtoResponse.setOrderItems(order.getOrderItems());
           orderDtoResponse.setCustomer(order.getCustomer());
            orderDtoResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
            orderDtoResponse.setBillingAddress(order.getBillingAddress());
            orderDtoResponse.setShippingAddress(order.getShippingAddress());
            orderDtoResponse.setStatus(order.getStatus());
            orderDtoResponse.setTotalPrice(order.getTotalPrice());
            orderDtoResponse.setTotalQuantity(order.getTotalQuantity());

            orderDtoResponseList.add(orderDtoResponse);
        }
        return orderDtoResponseList;
    }
    @Override
    public OrderDtoResponse getOrderById(String id) {

        Optional<Order> orderOptional = orderRepository.findAllById(id);

        if (!orderOptional.isPresent()) {
            throw new RuntimeException("Order not Found");
        }
        Order orderinfo = orderOptional.get();
        OrderDtoResponse orderDtoResponse = new OrderDtoResponse();

        orderDtoResponse.setId(orderinfo.getId());
        orderDtoResponse.setOrderItems(orderinfo.getOrderItems());
       orderDtoResponse.setCustomer(orderinfo.getCustomer());
        orderDtoResponse.setOrderTrackingNumber(orderinfo.getOrderTrackingNumber());
       orderDtoResponse.setBillingAddress(orderinfo.getBillingAddress());
        orderDtoResponse.setShippingAddress(orderinfo.getShippingAddress());
        orderDtoResponse.setStatus(orderinfo.getStatus());
        orderDtoResponse.setTotalPrice(orderinfo.getTotalPrice());
        orderDtoResponse.setTotalQuantity(orderinfo.getTotalQuantity());
        return orderDtoResponse;
    }

    @Override
    public void updateOrder(OrderDtoRequest orderDtoRequest, String id) {

        Optional<Order> orderOptional = orderRepository.findAllById(id);
        if (!orderOptional.isPresent()) {
            throw new RuntimeException("Order not Found");
        }
        Order orderinfo = orderOptional.get();
        BeanUtils.copyProperties(orderDtoRequest, orderOptional);
        orderRepository.save(orderinfo);
    }

    @Override
    public void deleteOrder(String id) {
        Optional<Order> orderOptional = orderRepository.findAllById(id);
        if (!orderOptional.isPresent()) {
            throw new RuntimeException("Order Not Found");
        }
        Order orderinfo = orderOptional.get();
        orderRepository.delete(orderinfo);
    }
}
