package com.practice.michael.demo.Controllers;

import com.practice.michael.demo.DAOs.EmployeeDAO;
import com.practice.michael.demo.DTOs.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    //cannot find inject import, will replace later
    @Autowired
    EmployeeDAO employeeDAO;


    @GetMapping("/{id}")
    public Employee getOneEmployee(Employee employee) {
        return employeeDAO.findOne(employee);
    }

}
