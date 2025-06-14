package com.sk.springtransaction.db;

import com.sk.springtransaction.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // You can add custom query methods here if needed
}
