package com.practice.michael.demo.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name="public.\"Employees\"")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee implements Serializable {

    @Column(name = "\"Employee_ID\"")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank
    private long employeeID;

    @Column(name = "\"Firstname\"")
    @NotBlank
    private String firstName;

    @Column(name = "\"Lastname\"")
    @NotBlank
    private String lastName;

    public long getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Employee_ID='" + employeeID + '\'' +
                ", FirstName=" + firstName +
                ", LastName=" + lastName +
                '}';
    }
}
