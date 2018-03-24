package com.practice.michael.demo;

import com.practice.michael.demo.DTOs.Employee;
import com.practice.michael.demo.Configuration.DBPostgresConfigAlternative;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(excludeFilters = {
		@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, value=DBPostgresConfigAlternative.class)
})
public class DemoApplication {
	public static void main(String[] args){
		SpringApplication.run(DemoApplication.class, args);
		String firstNameTarget = "Burk";
		demoFindEmployee(firstNameTarget);
	}
	private static void demoFindEmployee(String firstName){
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/api/employees/" + firstName;
		String lastName = null;
		Employee employee = restTemplate.getForObject(url, Employee.class);
		if(employee==null){
			System.out.format("The employee with the first name %s cannot be found.", firstName);
		}else {
			lastName = employee.getLastName();
			System.out.format("%s's last name is: %s", firstName, lastName);
		}
	}
}
