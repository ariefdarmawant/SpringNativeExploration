package com.spring.springCRUD.service;

import com.spring.springCRUD.entity.Balance;
import com.spring.springCRUD.entity.Employee;
import com.spring.springCRUD.exception.DataNotFoundException;
import com.spring.springCRUD.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee(String name) {
        if (name == null) {
            return employeeRepository.findAll();
        } else {
            return employeeRepository.findByNameContaining(name);
        }
    }

    public Employee getEmployeeWithId(String uid) {
        Optional<Employee> employee = employeeRepository.findById(uid);
        return employee.orElseThrow(() -> new DataNotFoundException(Employee.class, "Employee with uid : " + uid + " not found."));
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(String uid, Employee employee) {
        Optional<Employee> employeeData = employeeRepository.findById(uid);
        Employee saveEmployee = employeeData.orElseThrow(() -> new DataNotFoundException(Balance.class, "Employee with uid : " + uid + " not found."));;
        saveEmployee.setName(employee.getName());
        return employeeRepository.save(saveEmployee);
    }

    public Employee deleteEmployee(String uid) {
        Optional<Employee> employee = employeeRepository.findById(uid);
        employeeRepository.deleteById(uid);
        return employee.orElseThrow(() -> new DataNotFoundException(Balance.class, "Employee with uid : " + uid + " not found."));
    }
}
