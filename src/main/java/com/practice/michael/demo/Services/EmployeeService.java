package com.practice.michael.demo.Services;

import com.practice.michael.demo.DAOs.EmployeeDao;
import com.practice.michael.demo.DTOs.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;



       public List<Employee> findEmployeesByFirstName(String firstname){
        return employeeDao.getAllEmployeesWithFirstName(firstname);
    }

}
