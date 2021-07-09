package com.spring.springCRUD.repository;

import com.spring.springCRUD.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    List<Employee> findByNameContaining(String text);
}
