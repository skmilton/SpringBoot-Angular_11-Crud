package com.example.milton.repository;

import com.example.milton.domain.Employee;
import com.example.milton.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository <OrderItem, String>{

    Optional<OrderItem> findAllById(String id);
}
