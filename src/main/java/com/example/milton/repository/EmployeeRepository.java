package com.example.milton.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.milton.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{

	Optional<Employee>findAllById(String id);
}
