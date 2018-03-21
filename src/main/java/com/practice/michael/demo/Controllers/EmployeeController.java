package com.practice.michael.demo.Controllers;

import com.practice.michael.demo.DAOs.EmployeeDAO;
import com.practice.michael.demo.DTOs.Employee;
import com.practice.michael.demo.Exceptions.NoSuchEmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    //cannot find inject import, will replace later
    @Autowired
    EmployeeDAO employeeDAO;


    @GetMapping("/employees/{firstName}")
    public Employee getOneEmployee(String firstName) {
        return employeeDAO.findOne(firstName)
                .orElseThrow(() -> new NoSuchEmployeeException("Employee", "firstName", firstName));
    }

}
