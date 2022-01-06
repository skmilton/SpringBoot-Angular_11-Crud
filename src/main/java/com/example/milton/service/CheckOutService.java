package com.example.milton.service;

import com.example.milton.domain.Customer;
import com.example.milton.domain.Order;
import com.example.milton.domain.OrderItem;
import com.example.milton.domain.Purchase;
import com.example.milton.dto.response.PurchaseDtoResponse;
import com.example.milton.repository.CustomerRepository;
import com.example.milton.serviceIMPL.CheckOutServiceIMPL;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
@Data
@NoArgsConstructor
@Service
public class CheckOutService implements CheckOutServiceIMPL {

    private CustomerRepository customerRepository;
    public CheckOutService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public PurchaseDtoResponse placeOrder(Purchase purchase) {
        return null;
    }

//    @Override
//    @Transactional
//    public PurchaseDtoResponse placeOrder(Purchase purchase) {
//         retrieve the order info from dto
//        Order order = purchase.getOrder();
//
//         generate tracking number
//        String orderTrackingNumber = generateOrderTrackingNumber();
//        order.setOrderTrackingNumber(orderTrackingNumber);
//
//         populate order with orderItems
//        List<OrderItem> orderItems = purchase.getOrder().getOrderItems();
//        orderItems.forEach(item -> order.add(item));
//
//         populate order with shippingAddress and billingAddress
//        order.setBillingAddress(purchase.getBillingAddress());
//        order.setShippingAddress(purchase.getShippingAddress());
//
//         populate customer with order
//        Customer customer = purchase.getCustomer();
//        customer.add(order);
//
//         save to the database
//        customerRepository.save(customer);
//
//         return a response
//        return new PurchaseDtoResponse(orderTrackingNumber);
//    }
//
//    private String generateOrderTrackingNumber() {
//
//         generate a random UUID (UUID version-4)
//        return UUID.randomUUID().toString();
//    }


}
