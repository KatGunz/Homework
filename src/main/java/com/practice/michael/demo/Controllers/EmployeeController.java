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
    private int page;
    private int size;
    private String firstname;


    @GetMapping(path = "/{firstName}", params = { "page", "size" }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findEmployeeByFirstName(@RequestParam( "page" ) int page,
                                                          @RequestParam( "size" ) int size,
                                                          UriComponentsBuilder uriBuilder,
                                                          HttpServletResponse response,
                                                           @PathVariable String firstname) {
        this.page = page;
        this.size = size;
        this.firstname = firstname;
        List<Employee> employee = employeeService.findEmployeesByFirstName(firstname);
        if(employee==null){
            ResponseEntity.noContent().build();
        }else{
            //String is really a JSON, I should definitely
            //be more explicit about this instead of just calling
            //it a string
            return ResponseEntity.ok(new Gson().toJson(employee));
        }
        return ResponseEntity.ok(null);
    }

}
