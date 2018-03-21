package com.practice.michael.demo.DAOs;

import com.practice.michael.demo.DTOs.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, String>{
    Employee getEmployeeByFirstName(String s);
}
