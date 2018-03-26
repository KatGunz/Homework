package com.practice.michael.demo.DAOs;

import com.practice.michael.demo.DTOs.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long>{
    Employee getEmployeeByFirstName(String s);
}
