package com.example.milton.controller;

import com.example.milton.dto.request.OrderDtoRequest;
import com.example.milton.dto.response.OrderDtoResponse;
import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderInfoService ;

    @PostMapping("/create")
    public ResponseEntity<IdentificationResponse> createOrder(
            @RequestBody @Valid OrderDtoRequest orderDtoRequest, BindingResult bindingResult,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        return new ResponseEntity(orderInfoService.createOrder(orderDtoRequest), HttpStatus.CREATED);
    }
    @GetMapping("/show/all/list")
    public ResponseEntity<OrderDtoResponse> getAllOrder(){

        return new ResponseEntity(orderInfoService.getAllOrderList(), HttpStatus.OK);
    }

    @GetMapping("/show/list/by/{id}")
    public ResponseEntity<OrderDtoResponse> getAllOrderById(@PathVariable String id){
        return new ResponseEntity<OrderDtoResponse>(orderInfoService.getOrderById(id), HttpStatus.OK);


    }
    @PostMapping("/update/order/by/{id}")
    public void updateOrderList(@RequestBody OrderDtoRequest orderDtoRequest, @PathVariable String id) {
        orderInfoService.updateOrder(orderDtoRequest, id);
    }
    @DeleteMapping("/delete/orderList/by/{id}")
    public void deleteOrder(@PathVariable String id ) {
        orderInfoService.deleteOrder(id);
    }

}
