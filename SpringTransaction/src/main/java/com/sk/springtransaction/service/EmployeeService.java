package com.sk.springtransaction.service;

import com.sk.springtransaction.db.EmployeeRepository;
import com.sk.springtransaction.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional
    public void createEmployeeWithAddress(Employee employee) {
        employeeRepository.save(employee);
        System.out.println("Employee = " + employee);
        System.out.println("Address = " + employee.getAddress());


        // Simulate exception to check rollback
        if (employee.getName().equals("fail")) {
            throw new RuntimeException("Forcing rollback");
        }
    }
}
