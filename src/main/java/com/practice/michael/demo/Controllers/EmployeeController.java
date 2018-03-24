package com.practice.michael.demo.Controllers;

import com.practice.michael.demo.DTOs.Employee;
import com.practice.michael.demo.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping(path = "/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findEmployeeByFirstName(@PathVariable String firstName) {
        Employee employee = employeeService.findOneEmployee(firstName);
        if(employee==null){
            ResponseEntity.noContent().build();
        }else{
            //String is really a JSON, I should definitely
            //be more explicit about this instead of just calling
            //it a string
            return ResponseEntity.ok(employee.toString());
        }
        return ResponseEntity.ok(null);
    }

}
