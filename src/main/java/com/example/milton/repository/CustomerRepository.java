package com.example.milton.repository;

import com.example.milton.domain.Customer;import com.example.milton.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository


public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer>findAllById(String id);

}
