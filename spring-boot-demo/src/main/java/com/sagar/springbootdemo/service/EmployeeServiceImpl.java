package com.sagar.springbootdemo.service;


import com.sagar.springbootdemo.error.EmployeeNotFoundException;
import com.sagar.springbootdemo.model.Employee;
import org.springframework.stereotype.Service;
import com.sagar.springbootdemo.error.EmployeeNotFoundException;



import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{



    List<Employee> employeeList=new ArrayList<>();

    @Override
    public Employee save(Employee employee) {

        if(employee.getEmpId()==null || employee.getEmailId().isEmpty()){
            employee.setEmpId(UUID.randomUUID().toString());

        }
        employeeList.add(employee);


        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;

    }

    @Override
    public Employee getAEmployeeByID(String id) {
        return employeeList.stream().filter(employee -> employee.getEmpId().
                equalsIgnoreCase(id)).findFirst().
                orElseThrow(()->new EmployeeNotFoundException("Employee not found with Id"+id));

    }

    @Override
    public Employee deleteEmployeeByID(String id) {
        Employee employees=employeeList.stream().
                filter(e->e.getEmpId().equalsIgnoreCase(id)).
                findFirst().get();
        employeeList.remove(employees);


        return employees;

    }
}
