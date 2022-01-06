package com.example.milton.service;

import com.example.milton.domain.OrderItem;
import com.example.milton.dto.request.OrderItemDtoRequest;
import com.example.milton.dto.request.OrderItemDtoRequest;
import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.dto.response.OrderItemDtoResponse;
import com.example.milton.dto.response.OrderItemDtoResponse;
import com.example.milton.repository.OrderItemRepository;
import com.example.milton.serviceIMPL.OrderItemServiceIMPL;
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
public class OrderItemService implements OrderItemServiceIMPL {
    private OrderItemRepository orderItemRepository;
    private UuidUtil uuidUtil;

    @Override
    public IdentificationResponse createOrderItem(OrderItemDtoRequest orderItemDtoRequest) {

        String id = uuidUtil.getUuidUtil();

        OrderItem orderItemInformation = new OrderItem();
        orderItemInformation.setId(id);

        /*Bean Util Sob Entity thaka Sob nea asa*/
         BeanUtils.copyProperties(orderItemDtoRequest,orderItemInformation );

        orderItemRepository.saveAndFlush(orderItemInformation);

        return new IdentificationResponse(id);
    }

    @Override
    public List<OrderItemDtoResponse> getAllOrderItemList() {

        List<OrderItem> orderItemList = orderItemRepository.findAll();
        List<OrderItemDtoResponse> orderItemDtoResponseList = new ArrayList<>();
        for (OrderItem orderItem : orderItemList) {
            OrderItemDtoResponse orderItemDtoResponse = new OrderItemDtoResponse();

            orderItemDtoResponse.setId(orderItem.getId());
           orderItemDtoResponse.setOrder(orderItem.getOrder());
            orderItemDtoResponse.setUnitPrice(orderItem.getUnitPrice());
            orderItemDtoResponse.setQuantity(orderItem.getQuantity());
            orderItemDtoResponse.setProductId(orderItem.getProductId());
            orderItemDtoResponse.setImageUrl(orderItem.getImageUrl());

            orderItemDtoResponseList.add(orderItemDtoResponse);
        }

        return orderItemDtoResponseList;
    }

    @Override
    public OrderItemDtoResponse getOrderItemById(String id) {

        Optional<OrderItem> orderItemOptional = orderItemRepository.findAllById(id);

        if (!orderItemOptional.isPresent()) {
            throw new RuntimeException("OrderItem not Found");
        }
        OrderItem orderIteminfo = orderItemOptional.get();
        OrderItemDtoResponse orderItemDtoResponse = new OrderItemDtoResponse();

        orderItemDtoResponse.setId(orderIteminfo.getId());
       orderItemDtoResponse.setOrder(orderIteminfo.getOrder());
        orderItemDtoResponse.setUnitPrice(orderIteminfo.getUnitPrice());
        orderItemDtoResponse.setQuantity(orderIteminfo.getQuantity());
        orderItemDtoResponse.setProductId(orderIteminfo.getProductId());
        orderItemDtoResponse.setImageUrl(orderIteminfo.getImageUrl());


        return orderItemDtoResponse;
    }

    @Override
    public void updateOrderItem(OrderItemDtoRequest orderItemDtoRequest, String id) {

        Optional<OrderItem> orderItemOptional = orderItemRepository.findAllById(id);
        if (!orderItemOptional.isPresent()) {
            throw new RuntimeException("OrderItem not Found");
        }
        OrderItem orderIteminfo = orderItemOptional.get();

        /*Bean Util Sob Entity thaka Sob nea asa*/
        BeanUtils.copyProperties(orderItemDtoRequest, orderItemOptional);
        orderItemRepository.save(orderIteminfo);
    }

    @Override
    public void deleteOrderItem(String id) {
        Optional<OrderItem> orderItemOptional = orderItemRepository.findAllById(id);
        if (!orderItemOptional.isPresent()) {
            throw new RuntimeException("OrderItem Not Found");
        }
        OrderItem orderIteminfo = orderItemOptional.get();
        orderItemRepository.delete(orderIteminfo);
    }
}
