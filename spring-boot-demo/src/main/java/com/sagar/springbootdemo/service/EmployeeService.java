package com.sagar.springbootdemo.service;

import com.sagar.springbootdemo.model.Employee;

import java.util.List;

public interface EmployeeService {



    Employee save(Employee employee);

    List<Employee> getAllEmployees();

    Employee getAEmployeeByID(String id);
}
