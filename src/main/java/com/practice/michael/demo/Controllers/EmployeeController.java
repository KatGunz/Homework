package com.practice.michael.demo.Controllers;

import com.google.gson.Gson;
import com.practice.michael.demo.DTOs.Employee;
import com.practice.michael.demo.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;



    @GetMapping(path = "/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findEmployeeByFirstName(@PathVariable String firstName) {
        List<Employee> employees = employeeService.findEmployeesByFirstName(firstName);
        if(employees==null){
            return ResponseEntity.badRequest().build();
        }else{
            return ResponseEntity.ok(new Gson().toJson(employees));
        }
    }

}
