package com.example.milton.repository;

import com.example.milton.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State , String> {
    Optional<State> findAllById(String id);
}
