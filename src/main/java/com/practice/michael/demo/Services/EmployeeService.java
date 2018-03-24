package com.practice.michael.demo.Services;

import com.practice.michael.demo.DAOs.EmployeeDAO;
import com.practice.michael.demo.DTOs.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public Employee findOneEmployee(String firstName){
        return employeeDAO.getEmployeeByFirstName(firstName);
    }
}
