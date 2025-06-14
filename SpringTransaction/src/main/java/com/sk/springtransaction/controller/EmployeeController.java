package com.sk.springtransaction.controller;

import com.sk.springtransaction.entity.Employee;
import com.sk.springtransaction.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        System.out.println("controller");
        System.out.println(employee.toString()); // Check address not null
        try {
            employeeService.createEmployeeWithAddress(employee);
            return ResponseEntity.ok("Employee saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Transaction failed. Rolled back.");
        }
    }
}
