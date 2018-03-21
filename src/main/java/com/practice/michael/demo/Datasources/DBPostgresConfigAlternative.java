package com.practice.michael.demo.Datasources;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DBPostgresConfigAlternative {

    private static DriverManagerDataSource postGresDatasourceDriverManager = initializeDriverManager();

    private static DriverManagerDataSource initializeDriverManager() {
        DriverManagerDataSource driverManager = new DriverManagerDataSource();
        driverManager.setDriverClassName("org.postgresql.Driver");
        driverManager.setUrl("jdbc:postgresql://localhost:5432");
        driverManager.setUsername( "postgres" );
        driverManager.setPassword( "password" );
        return driverManager;
    }

    @Bean
    public DriverManagerDataSource getPostGresDatasourceDriverManager(){
        return postGresDatasourceDriverManager;
    }
}
