package com.practice.michael.demo.Controllers;

import com.practice.michael.demo.DAOs.EmployeeDAO;
import com.practice.michael.demo.DTOs.Employee;
import com.practice.michael.demo.Exceptions.NoSuchEmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    //cannot find inject import, will replace later
    @Autowired
    EmployeeDAO employeeDAO;


    @GetMapping("/{firstName}")
    public Employee findEmployeeByFirstName(@PathVariable("firstName") String firstName) {
        return employeeDAO.getEmployeeByFirstName(firstName);
    }

}
