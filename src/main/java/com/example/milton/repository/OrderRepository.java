package com.example.milton.repository;

import com.example.milton.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface OrderRepository extends JpaRepository <Order , String> {
    Optional<Order> findAllById(String id);
}
