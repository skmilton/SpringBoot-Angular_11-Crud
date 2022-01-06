package com.example.milton.repository;

import com.example.milton.domain.Employee;
import com.example.milton.domain.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LoginRepository extends JpaRepository<Login,String> {

    Optional<Login>findAllById(String id);
}
