package com.practice.michael.demo.Configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DBPostgresConfigAlternative {

    @Autowired
    private Environment env;

    @Autowired
    private LocalContainerEntityManagerFactoryBean entityManagerFactory;

    @Autowired
    private static DriverManagerDataSource postGresDriverManagerDataSource;

    @Bean
    private DriverManagerDataSource getPostGresDatasourceDriverManager() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver"));
        dataSource.setUrl(env.getProperty("spring.datasource.ur"));
        dataSource.setUsername( env.getProperty("spring.datasource.username") );
        dataSource.setPassword( env.getProperty("spring.datasource.password") );
        return dataSource;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory =
                new LocalContainerEntityManagerFactoryBean();

        entityManagerFactory.setDataSource(postGresDriverManagerDataSource);

        // Classpath scanning of @Component, @Service, etc annotated class
        entityManagerFactory.setPackagesToScan(
                env.getProperty("entitymanager.packagesToScan"));

        // Vendor adapter
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

        // Hibernate properties
        Properties additionalProperties = new Properties();
        additionalProperties.put(
                "spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults",
                env.getProperty("spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults"));
        additionalProperties.put(
                "spring.jpa.hibernate.hbm2ddl.auto",
                env.getProperty("spring.jpa.hibernate.hbm2ddl.auto"));
        additionalProperties.put(
                "spring.jpa.database-platform",
                env.getProperty("spring.jpa.database-platform"));
        entityManagerFactory.setJpaProperties(additionalProperties);

        return entityManagerFactory;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager =
                new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                entityManagerFactory.getObject());
        return transactionManager;
    }


}
