package com.practice.michael.demo;

import com.practice.michael.demo.Datasources.DBPostgresConfigAlternative;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(excludeFilters = {
		@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, value=DBPostgresConfigAlternative.class)
})
public class DemoApplication {
	public static void main(String[] args){
		SpringApplication.run(DemoApplication.class, args);
	}
}
