package com.example.milton.repository;

import com.example.milton.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address , String> {
    Optional<Address> findAllById(String id);
}
