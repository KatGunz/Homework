package com.practice.michael.demo.DAOs;

import com.practice.michael.demo.DTOs.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long>{

    List<Employee> findByFirstName(String firstname);
}
