package com.spring.springCRUD.controller;

import com.spring.springCRUD.entity.Employee;
import com.spring.springCRUD.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(@RequestParam(required = false) String name) {
        List<Employee> employees = service.getAllEmployee(name);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{uid}}")
    public ResponseEntity<Employee> getEmployeeWithId(@PathVariable("uid") String uid) {
        Employee employee = service.getEmployeeWithId(uid);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createEmployee(@Valid @RequestBody Employee employee) {
        service.createEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{uid}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("uid") String uid, @Valid @RequestBody Employee employee) {
        Employee employeeData = service.updateEmployee(uid, employee);
        return new ResponseEntity<>(employeeData, HttpStatus.OK);
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("uid") String uid) {
        Employee employee = service.deleteEmployee(uid);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
