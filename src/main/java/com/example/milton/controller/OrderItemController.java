package com.example.milton.controller;

import com.example.milton.dto.request.OrderItemDtoRequest;
import com.example.milton.dto.response.OrderItemDtoResponse;
import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.service.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("ordetitem")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemInfoService ;

    @PostMapping("/create")
    public ResponseEntity<IdentificationResponse> createOrderItem(
            @RequestBody @Valid OrderItemDtoRequest orderItemDtoRequest, BindingResult bindingResult,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        return new ResponseEntity(orderItemInfoService.createOrderItem(orderItemDtoRequest), HttpStatus.CREATED);
    }
    @GetMapping("/show/all/list")
    public ResponseEntity<OrderItemDtoResponse> getAllOrderItem(){

        return new ResponseEntity(orderItemInfoService.getAllOrderItemList(), HttpStatus.OK);
    }

    @GetMapping("/show/list/by/{id}")
    public ResponseEntity<OrderItemDtoResponse> getAllOrderItemById(@PathVariable String id){
        return new ResponseEntity<OrderItemDtoResponse>(orderItemInfoService.getOrderItemById(id), HttpStatus.OK);


    }
    @PostMapping("/update/orderItem/by/{id}")
    public void updateOrderItemList(@RequestBody OrderItemDtoRequest orderItemDtoRequest, @PathVariable String id) {
        orderItemInfoService.updateOrderItem(orderItemDtoRequest, id);
    }
    @DeleteMapping("/delete/orderItemList/by/{id}")
    public void deleteOrderItem(@PathVariable String id ) {
        orderItemInfoService.deleteOrderItem(id);
    }

}
