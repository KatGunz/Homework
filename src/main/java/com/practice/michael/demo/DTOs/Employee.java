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
    //renamed to id to abide by the restrictiveness
    // of the extra repo generating framework
    private Long id;

    @Column(name = "\"firstname\"")
    @NotBlank
    private String firstName;

    @Column(name = "\"lastname\"")
    @NotBlank
    private String lastName;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public boolean equals(Employee employee){
        //should I handle class cast exception here?
        //takes in object instead of employee to override superclass method
        if(this.id == employee.getId()
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
                "Employee_ID='" + id + '\'' +
                ", FirstName=" + firstName +
                ", LastName=" + lastName +
                '}';
    }
}
