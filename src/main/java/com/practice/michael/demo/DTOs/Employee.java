package com.practice.michael.demo.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name="\"employees\"", schema="public")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee implements Serializable {

    @Column(name = "\"employee_id\"")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank
    private long employeeID;

    @Column(name = "\"firstname\"")
    @NotBlank
    private String firstName;

    @Column(name = "\"lastname\"")
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

    //write a builder for this if possible
    @Override
    public boolean equals(Object o){
        //should I handle class cast exception here?
        //takes in object instead of employee to override superclass method
        Employee employee = (Employee) o;
        if(this.employeeID == employee.getEmployeeID()
                && this.lastName == employee.getLastName()
                && this.firstName == employee.getFirstName())
        {
            return true;
        }
        else{
            return false;
        }
    }
    //returns a JSON string of the object
    //write a builder for this if possible
    @Override
    public String toString() {
        return "Employee{" +
                "Employee_ID='" + employeeID + '\'' +
                ", FirstName=" + firstName +
                ", LastName=" + lastName +
                '}';
    }
}
