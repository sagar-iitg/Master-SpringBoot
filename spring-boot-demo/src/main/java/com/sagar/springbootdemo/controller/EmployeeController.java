package com.sagar.springbootdemo.controller;


import com.sagar.springbootdemo.model.Employee;
import com.sagar.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {



    @Autowired
    private EmployeeService employeeService;


    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){

        return employeeService.getAllEmployees();

    }


    @GetMapping("{id}")
    public Employee getAEmployeeByID(@PathVariable String id){

        return employeeService.getAEmployeeByID(id);

    }







}
