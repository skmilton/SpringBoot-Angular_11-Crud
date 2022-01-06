package com.example.milton.repository;

import com.example.milton.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country , String> {
    Optional<Country>findAllById(String id);
}
